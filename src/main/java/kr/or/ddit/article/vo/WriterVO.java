package kr.or.ddit.article.vo;

public class WriterVO {
	private String writerId;
	private String writerName;
	
	public WriterVO(String writerId, String writerName) {
		super();
		this.writerId = writerId;
		this.writerName = writerName;
	}
	public WriterVO() {

	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	@Override
	public String toString() {
		return "WriterVO [writerId=" + writerId + ", writerName=" + writerName + "]";
	}
	
	
}
