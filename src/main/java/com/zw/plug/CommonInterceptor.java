package com.zw.plug;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zw.cf.vo.TokenVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import java.io.PrintWriter;



/**
 * Created by zhaowei on 2017/6/29.
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
    private final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     * 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     * 执行下一个拦截器,直到所有的拦截器都执行完毕
     * 再执行被拦截的Controller
     * 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle()
     * 接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    @ResponseBody
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            //RequestUtil.saveRequest();
        }
        // 跨越代码===start====
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
        // 非常重要，如果前端http请求设置有自定义header一定要写在这里
        response.addHeader("Access-Control-Allow-Headers", "Content-Type, token");
        response.addHeader("Access-Control-Max-Age", "3600");
        // 跨越代码===end====

        // 如果请求url包含/cfmy/public/，不需要token验证，直接通过拦截
        String requestUri = request.getRequestURI();
        if(requestUri.indexOf("/cfmy/public/") != -1){
            return true;
        }

        // 默认token从http请求头里拿
        String token = request.getHeader("token");
        // 如果http请求头里没有，使用url参数名字为token的值
        if (token == null) {
            token = request.getParameter("token");
        }

        if(token!=null){
            // 根据token字符串，获取tokenVo，如果返回不为null，验证通过
            TokenVo tokenVo = TokenUtil.getTokenVo(token);
            if ( tokenVo!= null) {
                // 设置request属性tokenVo，在Controller里调用
                // 使用方法如下：
                // TokenVo tokenVo= (TokenVo) request.getAttribute("tokenVo");
                request.setAttribute("tokenVo",tokenVo);
                return true;
            }
        }

        // 上面未返回true，返回401
        Response response1 = new Response();
        response1.failure(401, "未经授权,服务器拒绝响应。");
        ObjectMapper objectMapper = new ObjectMapper();
        String userJsonStr = objectMapper.writeValueAsString(response1);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(userJsonStr);
        return false;
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {  //加入当前时间
            modelAndView.addObject("var", "测试postHandle");
        }
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     * <p>
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}