package kr.or.ddit.article.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.vo.ArticleVO;
import kr.or.ddit.article.vo.FilesVO;
import kr.or.ddit.article.vo.RealArticleVO;

public interface ArticleService {
	//article테이블로 insert
	public int insertArticle(ArticleVO articleVO) throws Exception;
	
	//게시글 목록 select
	public List<ArticleVO> selectArticle(Map<String, Object> map) throws Exception;
	
	//전체 게시글 행의 수(total)
	public int totalArticle() throws Exception;

	public int insertFiles(List<FilesVO> list);

	public List<RealArticleVO> specificArticle(int articleNo);

	public int count(int articleNo);
	
	public int checkIsFile(int articleNo);
	
	public RealArticleVO selectArticle2(int articleNo);
	
	public int updateArticle(ArticleVO articleVO);
	
	public int insertNewFiles(List<FilesVO> list);
	
	public int deleteFiles(int articleNo);
}
