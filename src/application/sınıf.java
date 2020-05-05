package application;

public class sýnýf {
	private String ad;
	private String memleket;
	private String meslek;
	private String cinsiyet;
	private Double ates;
	private String teshis;
	
	
	public sýnýf() {
		ad=null;
		memleket=null;
		meslek=null;
		cinsiyet=null;
		ates=0.0;
		teshis=null;
	
	}
	public sýnýf(String ad,String memleket,String meslek,String cinsiyet,Double ates,String teshis)
	{
		super();
		this.ad=ad;
		this.memleket=memleket;
		this.meslek=meslek;
		this.cinsiyet=cinsiyet;
		this.ates=ates;
		this.teshis=teshis;
		
		
		
	}
	
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getMemleket() {
		return memleket;
	}
	public void setMemleket(String memleket) {
		this.memleket = memleket;
	}
	public String getMeslek() {
		return meslek;
	}
	public void setMeslek(String meslek) {
		this.meslek = meslek;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public Double getAtes() {
		return ates;
	}
	public void setAtes(Double ates) {
		this.ates = ates;
	}
	public String getTeshis() {
		return teshis;
	}
	public void setTeshis(String teshis) {
		this.teshis = teshis;
	}
	
	

	




	
	}
	
	
	
	


