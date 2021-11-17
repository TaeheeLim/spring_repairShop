package kr.or.ddit.article.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.vo.ArticleVO;

public interface ArticleService {
	//article테이블로 insert
	public int insertArticle(ArticleVO articleVO) throws Exception;
	
	//게시글 목록 select
	public List<ArticleVO> selectArticle(Map<String, Object> map) throws Exception;
	
	//전체 게시글 행의 수(total)
	int totalArticle() throws Exception;
}
