package kr.or.ddit.article.vo;

import org.hibernate.validator.constraints.NotBlank;

public class ArticleVO {
	private int rnum;
	private int articleNo;
	private WriterVO writerVO;
	@NotBlank
	private String title;
	private String regdate;
	private String moddate;
	private ArticleContentVO articleContentVO;
	private int readCnt;
	
	//constructor
	public ArticleVO() {
		
	}
	
	public ArticleVO(int articleNo, WriterVO writerVO, String title, String regdate, 
							String moddate, ArticleContentVO articleContentVO, int readCnt) {
		this.articleNo = articleNo;
		this.writerVO = writerVO;
		this.title = title;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readCnt = readCnt;
		this.articleContentVO = articleContentVO;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public ArticleContentVO getArticleContentVO() {
		return articleContentVO;
	}

	public void setArticleContentVO(ArticleContentVO articleContentVO) {
		this.articleContentVO = articleContentVO;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public WriterVO getWriterVO() {
		return writerVO;
	}

	public void setWriterVO(WriterVO writerVO) {
		this.writerVO = writerVO;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	@Override
	public String toString() {
		return "ArticleVO [rnum=" + rnum + ", articleNo=" + articleNo + ", writerVO=" + writerVO + ", title=" + title
				+ ", regdate=" + regdate + ", moddate=" + moddate + ", articleContentVO=" + articleContentVO
				+ ", readCnt=" + readCnt + "]";
	}
}
