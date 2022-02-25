package kr.spring.ch06;

public class SystemMonitor {
	private long periodTime;
	private SmsSender sender;
	
	public SystemMonitor(long periodTime, SmsSender sender) { // super()는 생략해도 암묵적으로 포함됨
		this.periodTime = periodTime;
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "SystemMonitor [periodTime=" + periodTime + ", sender=" + sender + "]";
	}
}