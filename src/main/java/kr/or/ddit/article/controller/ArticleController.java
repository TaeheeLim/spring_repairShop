package kr.or.ddit.article.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.vo.ArticleContentVO;
import kr.or.ddit.article.vo.ArticlePage;
import kr.or.ddit.article.vo.ArticleVO;
import kr.or.ddit.article.vo.FilesVO;
import kr.or.ddit.article.vo.RealArticleVO;
import kr.or.ddit.article.vo.WriterVO;
import kr.or.ddit.emp.vo.EmpVO;

@RequestMapping("/article")
@Controller
public class ArticleController {
	private static final Logger logger =
			LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	ArticleService articleService;
	
	@GetMapping("/newArticleForm")
	public String newArticleForm(Model model) {
		model.addAttribute("article", new ArticleVO());
		
		//forwarding
		return "article/newArticleForm";
	}
	
	//글 입력
	@PostMapping("/newArticlePost")
	public String newArticlePost(@ModelAttribute("article") ArticleVO article
							 	  ,HttpServletRequest request
							 	  ,MultipartFile[] uploadFile) throws Exception {
		String path = "C:\\workspace (3)\\workspace\\dasuriProj\\src\\main\\webapp\\resources\\upload";
		
		List<FilesVO> list = new ArrayList<>();
		
		for(MultipartFile file : uploadFile) {
			logger.info("업로드 파일명 : " + file.getOriginalFilename());
			
			UUID uuid = UUID.randomUUID();
			String uuidFileName = file.getOriginalFilename();
			
			
			uuidFileName = uuid.toString() + "_" + uuidFileName;
			logger.info("uuidFileNames = " + uuidFileName);
			
			File saveFile
				= new File(path, uuidFileName);
			
			try {
				file.transferTo(saveFile);
				list.add(new FilesVO(0, uuidFileName, 0));
				
			} catch (IOException e) {
				logger.error(e.getMessage());
			} 
		}
		
		HttpSession session = request.getSession();
		//EMPVO라는 이름의 세션 정보를 가져와 직원데이터를 empVO 객체에 할당 
		EmpVO empVO = (EmpVO)session.getAttribute("EMPVO");
		//작성자 직원 번호, 작성자 명을 할당
		WriterVO writerVO = new WriterVO(empVO.getEmpNo(), empVO.getNm());
		//article 객체의 작성자 중첩객체 필드로 setting을 함
		article.setWriterVO(writerVO);
		
		logger.info("article : " + article.toString());
		
		//article : ArticleVO [articleNo=0, WriterVO=NULL, title=제목,
		//regdate=null, moddate=null,
		//articleContentVO=kr.or.ddit.article.vo.ArticleContentVO@42e101e4,
		//readCnt=0]
		int result = this.articleService.insertArticle(article);
		logger.info("========================================================");
		for(FilesVO vo : list) {
			logger.info(vo.toString());			
		}
		logger.info("========================================================");
		
		this.articleService.insertFiles(list);
		logger.info("result : " + result);
		
		return "article/newArticleSuccess";
	}
	
	@PostMapping("/updateArticle")
	public String updateArticle(MultipartFile[] uploadFile
								, HttpServletRequest request
								, @ModelAttribute("vo") ArticleVO vo) {
		String path = 
				"C:\\workspace (3)\\workspace\\dasuriProj\\src\\main\\webapp\\resources\\upload";
		
		logger.info("update할때 넘어오는 vo ??? : " + vo.toString());
		
		List<FilesVO> list = new ArrayList<>();
		
		for(MultipartFile file : uploadFile) {
			logger.info("업로드 파일명 : " + file.getOriginalFilename());
			
			UUID uuid = UUID.randomUUID();
			String uuidFileName = file.getOriginalFilename();
			
			
			uuidFileName = uuid.toString() + "_" + uuidFileName;
			logger.info("uuidFileNames = " + uuidFileName);
			
			File saveFile
				= new File(path, uuidFileName);
			
			try {
				file.transferTo(saveFile);
				list.add(new FilesVO(0, uuidFileName, vo.getArticleNo()));
			} catch (IOException e) {
				logger.error(e.getMessage());
			} 
		}
		
		HttpSession session = request.getSession();
		//EMPVO라는 이름의 세션 정보를 가져와 직원데이터를 empVO 객체에 할당 
		EmpVO empVO = (EmpVO)session.getAttribute("EMPVO");
		//작성자 직원 번호, 작성자 명을 할당
		WriterVO writerVO = new WriterVO(empVO.getEmpNo(), empVO.getNm());
		//article 객체의 작성자 중첩객체 필드로 setting을 함
		vo.setWriterVO(writerVO);
		
		logger.info("article : " + vo.toString());
		
		//article : ArticleVO [articleNo=0, WriterVO=NULL, title=제목,
		//regdate=null, moddate=null,
		//articleContentVO=kr.or.ddit.article.vo.ArticleContentVO@42e101e4,
		//readCnt=0]
		int result = this.articleService.updateArticle(vo);
		logger.info("========================================================");
		for(FilesVO fvo : list) {
			logger.info(fvo.toString());			
		}
		logger.info("========================================================");
		this.articleService.deleteFiles(vo.getArticleNo());
		
		this.articleService.insertNewFiles(list);
		logger.info("result : " + result);
		
		return "redirect:/article/listArticle";
	}
	 
	//	/article/listArticle?currentPage=2
	@GetMapping("/listArticle")
	public String listArticle(Model model,
			@RequestParam(value="currentPage", defaultValue = "1") String currentPage) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();

		//전체 게시글 행의 수(total)
		int total = this.articleService.totalArticle();
//		int total = mapList.size();
		
		map.put("currentPage", currentPage);
		//article, article_content 조인 결과 목록
		List<ArticleVO> mapList 
			= this.articleService.selectArticle(map);
		
		//size : 한 화면에 보여지는 행의 수
		model.addAttribute("articlePage", 
				new ArticlePage(total, Integer.parseInt(currentPage),
						10, mapList));
		//게시글 목록 화면
		return "article/listArticle";
	}
	
	@GetMapping("/seeArticle")
	public String seeArticle(@RequestParam(value="id") String id, Model model) {
		logger.info("게시판 조회로 넘어가기전의 기본키 : " + id);
		articleService.count(Integer.parseInt(id));
		
		int checkIsFile = articleService.checkIsFile(Integer.parseInt(id));
		
		if(checkIsFile != 0) {
			logger.info("파일이 있는 게시물!!!!!!!!!!!!!!!!!!!!!!");
			//파일 테이블에 아티클 테이블의 기본키가 외래키로 잡혀있어서 중복된 행이 여러개 출력
			List<RealArticleVO> specificArticle = this.articleService.specificArticle(Integer.parseInt(id));
			logger.info("넘어오는거 : " + specificArticle.toString());
			
			logger.info("리스트의 크기 : " + specificArticle.size());
			logger.info("list to string : " + specificArticle.toString() );
			//파일 이름을 담아주기 위한 리스트 객체 생성
			List<String> fileList = new ArrayList<>();
			
			RealArticleVO vo = specificArticle.get(0);
			
			logger.info("vo에 복사한 객체 : " + vo.toString());
			
			//해당 게시글에 대한 정보를 새로운 리스트에 복사
			
			//파일 이름만 리스트 객체에 담아줌
			for(int i = 0; i < specificArticle.size(); i++) {
				logger.info(specificArticle.get(i).getFileName());
				fileList.add(specificArticle.get(i).getFileName());
			}
			
			logger.info("파일 이름이 담긴 리스트 : " + fileList.toString());
			
			model.addAttribute("fileList", fileList);
			model.addAttribute("vo", vo);
			
			return "article/seeArticle";
		} else {
			logger.info("파일이 없는 게시물!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			RealArticleVO vo = this.articleService.selectArticle2(Integer.parseInt(id));
			
			model.addAttribute("vo", vo);
			
			return "article/seeArticle";
		}
	}
		
	@GetMapping("/update")
	public String update(Model model, @RequestParam(value="no") String no) {
		logger.info("/update로 넘어온 고유번호" + no);
		logger.info("컨트롤러에서 update로 이동");
		
		int checkIsFile = articleService.checkIsFile(Integer.parseInt(no));
		//파일이 있다면
		if(checkIsFile != 0) {
			logger.info("update할때 파일이 있다면!!!!!!!!!!!!");
			List<RealArticleVO> specificArticle = articleService.specificArticle(Integer.parseInt(no));
			List<String> fileList = new ArrayList<>();
			
			RealArticleVO vo = specificArticle.get(0);
			
			for(int i = 0; i < specificArticle.size(); i++) {
				logger.info(specificArticle.get(i).getFileName());
				fileList.add(specificArticle.get(i).getFileName());
			}
			
			logger.info("파일 이름이 담긴 리스트 : " + fileList.toString());
//			vo.setContent("");
			
			model.addAttribute("fileList", fileList);
			model.addAttribute("vo", vo);
			model.addAttribute("ArticleNo",no);
			
			return "article/updateArticle";
		} else {	//파일이 없다면
			logger.info("update할때 파일이 없다면!!!!!!!!!!!!");
			RealArticleVO vo = this.articleService.selectArticle2(Integer.parseInt(no));
			
			model.addAttribute("vo", vo);
			model.addAttribute("ArticleNo",no);
			
			return "article/updateArticle";
		}
	}
	
	@RequestMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent ,String fileName) {
       
       logger.info("download file : " + fileName);
       
       //파일이 있는 절대 경로
       String uploadFolder = "C:\\workspace (3)\\workspace\\dasuriProj\\src\\main\\webapp\\resources\\upload";
       
       // ...resources\\upload\\2021\\11\\05\\개똥이.jpg
       Resource resource = new FileSystemResource(uploadFolder  + "\\"+ fileName);
       
       //해당 파일이 없을때...
       if(!resource.exists()) {
          return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
       }
       
       logger.info("resource => " + resource);
       
       //파일명 가져오기
       String resourceName = resource.getFilename();
       
       //파일명이 한글이면 httpHeaders 객체를 통해 처리
       HttpHeaders headers = new HttpHeaders();
       
       try {
          // 헤더의 파일이름 처리하기 전에 해줘야함
          String downloadName = null;
          // Trident => IE 11버전의 엔진이름, 즉 IE를 나타냄
          if(userAgent.contains("Trident")) {
             logger.info("IE browser");
             
             downloadName = URLEncoder.encode(resourceName, "UTF-8").replaceAll("\\+", " ");
          } else if(userAgent.contains("Edg")) {
             logger.info("Edge browser");
             
             downloadName = URLEncoder.encode(resourceName, "UTF-8");
          }else{
             logger.info("chrome browser");
             
             downloadName = new String(resourceName.getBytes("UTF-8"), "ISO-8859-1");
          }
          
          //Content-disposition : 다운로드시 저장되는 이름을 처리하라
          headers.add("Content-disposition", "attachment;filename="+ downloadName);
       } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
       }
       
       // resource : 첨부파일 객체
       // headers : 파일명 처리 정보
       // HttpStatus.OK : 200(성공)
       return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }
}
