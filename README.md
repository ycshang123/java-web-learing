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