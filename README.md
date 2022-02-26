# JavaWeb课程学习记录

## day01-servlet

1. ServletDemo
   1. 注解配置方式配置Servlet，实现Servlet接口，了解Servlet声明周期
2. ServletDemo1
   1. 以xml配置文件的形式请求servlet，具体配置信息见web.xml
3. ServletDemo2
   1. 了解servlet接口中的各个方法，以xml形式配置请求servlet
      1. init(ServlteConfig servletConfig)  初始化，在Servlet被创建时执行，只执行一次
      2. getServletConfig() 获取ServletConfig配置对象
      3. service(ServletRequest req,ServletResponse resp) 提供服务方法，每一次Servlet被访问时执行，可以执行多次
      4. getServlet() 获得Servlet的一些信息:版本、作者等
      5. destroy() 销毁，在服务器正常关闭时执行，只执行一次
   2. xml文件配置请求Servelt接口
      1. 指定Servlet的创建时机
         1. 第一次访问时创建<load-on-startup>的值为负数
         2. 在服务器启动时创建<load-on-startup>的值为0或正整数
4. ServletDemo3
   1. 继承HttpServlet实现doGet()和doPost()方法
5. ServletDemo4
   1. Servlet各种路径配置

## day02-request

1. RequestDemo1
   1. 获取请求行数据
      1. 获取请求方式：request.getMethod()
      2. 获取虚拟目录：request.getContextPath()
      3. 获取Servlet路径：request.getServletPath()
      4. 获取get方式请求参数：request.getQueryString()
      5. 获取请求URI：request.getRequestURI()
      6. 获取请求URL：request.getRequestURL()
      7. 获取协议及版本：request.getProtocol()
      8. 获取客户机IP地址：request.getRemoteAddr()
2. RequestDemo2
   1. Request对象获取请求头
      1. 获取所有请求头名称：request.getHeaderName()
3. RequestDemo3
   1. Request对象获取请求头数据
      1. 获取请求头数据：request.getHeader("user-agent")
4. RequestDemo4
   1. Request对象获取请求头数据
5. RequestDemo5
   1. 获取请求消息体——请求参数
6. RequestDemo6
   1. 根据参数名称获取参数值：request.getParameter()
   2. 根据参数名称获取参数值的数组：request.getParamterValues()
   3. 获取所有请求的参数名称：request.getParamterNames()
   4. 获取所有参数的map集合：request.getParameterMap()
7. RequestDemo7
   1. 设置请求参数字符集：request.setCharsetEncoding()
8. RequestDemo8
   1. 跳转转发：request.getRequestDispatcher("/").forward(request,response)
9. RequestDemo9
   1. forward转发
10. RequestDemo10
    1. 获得全局ServletContext：request.getServletContext()