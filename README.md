# spring-boot-web-template

How to simple start application
mvn spring-boot:run

What port app using?
server.port=8180

3/2/19  
First endpoint created is <code>/categorias</code> and working on!
  - Use annotation <code>@RequestController</code> to map a REST class;
  - <code>@RequestMapping</code> to map a path of REST class;

3/2/19  
Second endpoint created. filter categorias by cod <code>/categorias/{cod}</code>
  - Using @RequestMapping to add value to <code>{cod}</code>;
  - Using @PathVariable to get value and set up param cod in the method;
  - With <code>stream().filter()</code> of java8, we can return just category filtered in url by cod;




