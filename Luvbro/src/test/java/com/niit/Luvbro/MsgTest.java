package com.niit.Luvbro;

//import com.niit.Luvbro.model.SendError;
import com.niit.Luvbro.model.SendSms;

public class MsgTest  
{
	public static void main(String a[])
	{
		SendSms s=new SendSms();
		s.setFrom(9900089199l);
		s.setTo(1234567890l);
		s.setSub("Seeking information about college fest.");
		s.setMsg("Madhu,when is your college fest gonna start.");
		if(s.getFrom()==0l || s.getMsg()==null || s.getSub()==null || s.getTo()==0l)
		{
			s.setErr(404);
			s.setMssg("Message not sent");
			s.setStatus("Failed");
			System.out.println("Error:"+s.getErr());
			System.out.println("Message:"+s.getMssg());
			System.out.println("Status:"+s.getStatus());
		}
		else
		{
			s.setErr(202);
			s.setMssg("Message sent successfully");
			s.setStatus("Successfull");
			System.out.println("Error:"+s.getErr());
			System.out.println("Message:"+s.getMssg());
			System.out.println("Status:"+s.getStatus());
		}
		
	}

}
