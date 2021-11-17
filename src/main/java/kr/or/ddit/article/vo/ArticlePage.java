package kr.or.ddit.article.vo;

import java.util.List;

public class ArticlePage {
	private int total;	//전체 행의 수 : 70
	private int currentPage;	//현재 페이지 번호
	private List<ArticleVO> content;	//게시글 목록
	private int totalPages;	//전체 페이지 수	: 7
	private int startPage;	//시작 페이지 번호	[*1] [2] [3] [4] [5] 다음
	private int endPage;	//종료 페이지 번호	[1] [2] [3] [4] [*5] 다음
	
	//constructor
	public ArticlePage() {}

	public ArticlePage(int total, int currentPage, int size, List<ArticleVO> content) {
		super();
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		if(total == 0) {	//결과 행이 없을 때
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {	//결과 행이 있을 때
			//72행이 있고 5페이지 씩 묶을 때, 한 화면에 10개 씩 보일 때
			// 7 <= 72 / 10
			totalPages = total / size;
			//나머지 행이 있으면 전체 페이지수를 1 증가
			if(total % size > 0) {
				totalPages++;
			}
			//시작 페이지번호 공식
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;
			//묶음의 마지막 페이지가 현재 페이지일 때.....
			if(modVal == 0) startPage -= 5;
			
			endPage = startPage + 4;
			//[1] [2] [3] [4] [5]
			//[6(startPage)] [7] [8(totalPages)]  9...10(endPage)
			if(endPage > totalPages) endPage = totalPages;
			
		}
	}//end constructor

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<ArticleVO> getContent() {
		return content;
	}

	public void setContent(List<ArticleVO> content) {
		this.content = content;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "ArticlePage [total=" + total + ", currentPage=" + currentPage + ", content=" + content + ", totalPages="
				+ totalPages + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
	
	
	
	
}
