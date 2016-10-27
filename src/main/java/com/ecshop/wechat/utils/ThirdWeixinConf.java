package com.ecshop.wechat.utils;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 14:40
 * 这里放置各种配置数据
 */
public class ThirdWeixinConf {
	
	 /**
     * 公众号第三方平台component_verify_ticket协议
     */
	public static final int TYPE_COMPONENTVERIFYTICKET = 1;
	
	/**
	 * 公众号access_token
	 */
	public static final int TYPE_ACCESSTOKEN = 2;
    	
    
	
	/**AppID**/
	/**
	 * 微信第三方平台APPID
	 */
	//public static final String APPID = "wx9d39daae2cd68339";//"wxdf7f6f73174b12b4";
	/**
	 * 微信第三方平台密钥
	 */
	//public static final String APPSECRET = "561a32ca788807691e8929d881f3248f";//"0c79e1fa963cd80cc0be99b20a18faeb";
	/**
	 * 公众号消息校验Token
	 */
	//public static final String ENCRYPTION_TOKEN = "VVE-LINK";
	/**
	 * 公众号消息加密Key
	 */
	//public static final String ENCRYPTION_KEY = "cee09da126f19c7b104acdc5c65bf4e9dc5c65bf4e9";//"cee09da126f19c7b104acdc5c65bf4e9dc5c65bf4e9";
	/**
	 * 公众号网页开发域名
	 */
	//public static final String DOMAIN = "http://oauth.m.vvelink.net";//"http://wxserver.vvelink.net";
	
	/**获取第三方平台access_token**/
	public static final String API_COMPONENT_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
	/**获取第三方平台预授权码**/
	public static final String API_CREATE_PREAUTHCODE = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=";
	/**获取第三方平台预授权码**/
	public static final String COMPONENTLOGINPAGE = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?";
	/**刷新公众号access_token**/
	public static final String API_AUTHORIZER_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=";
	/**第三方平台使用授权码换取公众号的授权信息**/
	public static final String API_QUERY_AUTH = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=";
	/**第三方平台获取授权方的账户信息**/
	public static final String API_GET_AUTHORIZER_INFO = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=";
	/**
	 * 第三方平台获取授权方的jsapi_ticket
	 * 采用http GET方式请求获得jsapi_ticket（有效期7200秒，开发者必须在自己的服务全局缓存jsapi_ticket）：
	 * https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
	 * 获得jsapi_ticket之后，就可以生成JS-SDK权限验证的签名了
	 * 
	 * */
	public static final String JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";
	
	/**
	 * 菜单创建请求地址
	 */
	public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	
	/**代授权1.请求CODE**/
	public static final String AUTHORIZE = "https://open.weixin.qq.com/connect/oauth2/authorize";
	/**代授权2.请求Access_Token**/
	public static final String ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/component/access_token";
	/**代授权3.请求Userinfo**/
	public static final String USERINFO = "https://api.weixin.qq.com/sns/userinfo";
	
	/**
	 * 发送模板消息地址
	 */
	public static final String SEND_TEMPATE_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
	/**
	 * 获得微信模板ID地址
	 */
	public static final String GET_TEMPATE_MESSAGE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=";
	
	/**
	 * 开发者可通过OpenID来获取用户基本信息
	 * http请求方式: GET
	 * 
	 */
	public static final String USERINFO_ = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=";
	
	/**
	 * 微信授权作用域snsapi_base
	 */
	public static final String SCOPE_SNSAPI_BASE = "snsapi_base";
	
	/**
	 * 微信授权作用域snsapi_userinfo
	 */
	public static final String SCOPE_SNSAPI_USERINFO = "snsapi_userinfo";
	
}
