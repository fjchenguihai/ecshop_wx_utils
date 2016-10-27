package com.ecshop.wechat.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.ecshop.util.HttpRequest;



public class WeChatUtil {
	
	/**
	 * 拼装授权请求CODE地址(第三方代替公众号发起的授权)
	 * @param thirdPlatAppId 第三方平台APPID
	 * @param appId 公众号APPID(eg: wx0868c02492d15493)
	 * @param scope 授权作用域
	 * @param state 参数 最多128字节
	 * @param redirectURL 重定向地址
	 * @return
	 */
	public static String getWeixinCodeForPlat(String thirdPlatAppId,String appId,String scope,String state,String redirectURL){
		StringBuffer sb= new StringBuffer();
		sb.append("appid="+appId);
		try {
			sb.append("&redirect_uri="+URLEncoder.encode(redirectURL, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append("&response_type=code&scope="+scope);
		sb.append("&state="+state+"&component_appid="+thirdPlatAppId+"#wechat_redirect");
		String str = ThirdWeixinConf.AUTHORIZE+"?"+sb.toString();
		return str;
	}
	
	/**
	 * 拼装授权请求code地址(通过公众号自身发起)
	 * @param appId 公众号APPID
	 * @param scope 授权作用域
	 * @param state 参数 最多128字节
	 * @param redirectURL 重定向地址
	 * @return
	 */
	public static String getWeixinCodeForSelf(String appId,String scope,String state,String redirectURL){
		StringBuilder sb= new StringBuilder();
		sb.append("appid="+appId);
		try {
			sb.append("&redirect_uri="+URLEncoder.encode(redirectURL, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append("&response_type=code");
		sb.append("&scope="+scope);
		sb.append("&state="+state);
		sb.append("#wechat_redirect");
		String str = ThirdWeixinConf.AUTHORIZE+"?"+sb.toString();
		return str;
	}
	/**
	 * 通过code换取access_token(通过第三方平台)
	 * @param componentAppId 平台ID
	 * @param appId 公众号ID
	 * @param code 授权code
	 * @param componentAccessToken 平台access token
	 * @return
	 */
	public static String getAccessTokenByCodeForPlat(String componentAppId,String appId,String code,String componentAccessToken ){
		StringBuilder sb= new StringBuilder();
		sb.append("appid="+appId);
		sb.append("&code="+code);
		sb.append("&grant_type=authorization_code");
		sb.append("&component_appid="+componentAppId);
		sb.append("&component_access_token="+componentAccessToken);
		String str = ThirdWeixinConf.ACCESS_TOKEN+"?"+sb.toString();
		return str;	
	}
	
	
	/**
	 * 通过网页授权access_token获取用户基本信息（需授权作用域为snsapi_userinfo）
	 * @param openId
	 * @param accessToken
	 * @return
	 */
	public static String getUserInfoByAccessToken(String openId,String accessToken){
		String result = null;
		String reqURL = ThirdWeixinConf.USERINFO+"?access_token="+accessToken+"&openid="+openId+"&lang=zh_CN";
		result = HttpRequest.sendGet(reqURL);
		return result;
	}
	
	/**
	 * 专门解析微信state参数
	 * (类似：{state=userid=1,appid=gh_e7ba7987a0d1} 参数值不允许出现=)
	 * @param stateStr
	 * @return
	 */
	public static String getStateJSONStr(String state){
		String stateStr = null;
		if(state!=null){
			state=state.substring(1);
			state=state.substring(0,state.length()-1);
			String[] strArr = state.split(",");
			StringBuffer stateJson=new StringBuffer("{");
			for (int i = 0; i < strArr.length; i++) {
				String[] tmpStrArr =strArr[i].split("=");
				if(tmpStrArr!=null && tmpStrArr.length>0){
					if(tmpStrArr.length<2){
						stateJson.append("\""+tmpStrArr[0]+"\":\"\",");
					}else{
						stateJson.append("\""+tmpStrArr[0]+"\":\""+tmpStrArr[1]+"\",");
					}
				}
			}
			stateStr=stateJson.substring(0, stateJson.lastIndexOf(","));
			stateStr=stateStr+"}";
		}
		
		return stateStr;
	}
	
	
	public static String[] parseBackURL(String url){
		String[] urlStrArray =  null;
		if(!StringUtils.isEmpty(url)){
			if(url.indexOf("?")>0){
				urlStrArray = new String[2];
				urlStrArray[0] = url.substring(0,url.indexOf("?") );
				urlStrArray[1] = url.substring(url.indexOf("?")+1);
			}else{
				urlStrArray = new String[]{url};
			}
		}
		return urlStrArray;
	}
	
	/**
	 * 拼接商城登录地址
	 * @param host
	 * @return
	 */
	public static String getMallHomePage(String host){
		StringBuilder home = new StringBuilder();
		if(!StringUtils.isEmpty(host)){
			home.append(host);
			home.append("/login/login.do");
		}
		return home.toString();
	}
	
	
	/**
	 * 请求创建微信菜单URL
	 * @param accessToken
	 * @return
	 */
	public static String getWeixinMenuCreateURL(String accessToken){
		StringBuilder url = new StringBuilder(ThirdWeixinConf.MENU_CREATE_URL); 
		url.append(accessToken);
		return url.toString();
	}
	
	public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
	
	/**
	 * 获取当前时间(秒为单位)
	 * @Description TODO
	 * @return
	 * @throws
	 */
	public static String getTimestamp() {
	      return Long.toString(System.currentTimeMillis() / 1000);
	}
	
	
	
}
