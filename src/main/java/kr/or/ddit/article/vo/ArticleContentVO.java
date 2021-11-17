package kr.or.ddit.article.vo;

public class ArticleContentVO {
	private int articleNo;
	private String content;
	
	public ArticleContentVO(int articleNo, String content) {
		super();
		this.articleNo = articleNo;
		this.content = content;
	}
	
	public ArticleContentVO() {
		
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ArticleContentVO [articleNo=" + articleNo + ", content=" + content + "]";
	}
}
