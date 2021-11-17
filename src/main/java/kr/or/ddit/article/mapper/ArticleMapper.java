package kr.or.ddit.article.mapper;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.vo.ArticleVO;

public interface ArticleMapper {
	//article테이블로 insert
	int insertArticle(ArticleVO articleVO);
	
	//article_Content테이블로 insert
	int insertArticleContent(ArticleVO articleVO);
	
	//게시글 목록 select
	List<ArticleVO> selectArticle(Map<String, Object> map);

	//전체 게시글 행의 수(total)
	int totalArticle();
}
