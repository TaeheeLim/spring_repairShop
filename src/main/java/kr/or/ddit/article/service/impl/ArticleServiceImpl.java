package kr.or.ddit.article.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.article.mapper.ArticleMapper;
import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.vo.ArticleVO;
import kr.or.ddit.article.vo.FilesVO;
import kr.or.ddit.article.vo.RealArticleVO;

@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleMapper articleMapper;
	
	@Override
	public int insertArticle(ArticleVO articleVO) throws Exception {
		//글정보 테이블로 insert
		//articleNo <= 0
		int result = this.articleMapper.insertArticle(articleVO);
		
		//글내용 테이블로 insert
		//articleNo <= max(ARTICLE_NO)
		this.articleMapper.insertArticleContent(articleVO);
		
		return result;
	}
	
	@Override
	public List<ArticleVO> selectArticle(Map<String, Object> map) throws Exception{
		return this.articleMapper.selectArticle(map);
	}
	
	//전체 게시글 행의 수(total)
	@Override
	public int totalArticle() throws Exception {
		return this.articleMapper.totalArticle();
	};
	
	@Override
	public int insertFiles(List<FilesVO> list) {
		return this.articleMapper.insertFiles(list);
	}
	
	@Override
	public int insertNewFiles(List<FilesVO> list) {
		return this.articleMapper.insertNewFiles(list);
	};
	
	@Override
	public List<RealArticleVO> specificArticle(int articleNo){
		return this.articleMapper.specificArticle(articleNo);
	}

	@Override
	public int count(int articleNo) {
		return this.articleMapper.count(articleNo);
	}

	@Override
	public int checkIsFile(int articleNo) {
		return this.articleMapper.checkIsFile(articleNo);
	}

	@Override
	public RealArticleVO selectArticle2(int articleNo) {
		return this.articleMapper.selectArticle2(articleNo);
	}

	@Override
	public int updateArticle(ArticleVO articleVO) {
		int result = this.articleMapper.updateArticle(articleVO);
		this.articleMapper.updateArticleContent(articleVO);
		return result;
	}

	@Override
	public int deleteFiles(int articleNo) {
		return this.articleMapper.deleteFiles(articleNo);
	}
	
	@Override
	public int deleteArticle(int articleNo) {
		return this.articleMapper.deleteArticle(articleNo);
	}
	
	@Override
	public List<RealArticleVO> searchArticle(Map<String, Object> map) {
		return this.articleMapper.searchArticle(map);
	}
}
