package kr.or.ddit.article.mapper;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.vo.ArticleVO;
import kr.or.ddit.article.vo.FilesVO;
import kr.or.ddit.article.vo.RealArticleVO;

public interface ArticleMapper {
	//article테이블로 insert
	int insertArticle(ArticleVO articleVO);
	
	//article_Content테이블로 insert
	int insertArticleContent(ArticleVO articleVO);
	
	//files 테이블로 insert
	int insertFiles(ArticleVO articleVO);
	
	//게시글 목록 select
	List<ArticleVO> selectArticle(Map<String, Object> map);

	//전체 게시글 행의 수(total)
	int totalArticle();
	
	int insertFiles(List<FilesVO> list);
	
	List<RealArticleVO> specificArticle(int articleNo);
	
	int count(int articleNo);
	
	int checkIsFile(int articleNo);
	
	RealArticleVO selectArticle2(int articleNo);
	
	int updateArticle(ArticleVO articleVO);
	
	int updateArticleContent(ArticleVO articleVO);
	
	int insertNewFiles(List<FilesVO> list);
	
	int deleteFiles(int articleNo);
	
	int deleteArticle(int articleNo);
	
	List<RealArticleVO> searchArticle(Map<String, Object> map);
}
