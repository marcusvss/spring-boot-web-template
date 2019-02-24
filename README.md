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

7/2/19  
Implements domain Produtos as well its Service and Repository
  - Mapped with <code>@ManyToMany</code> in Categoria Entity
  - Categoria mapped as <code>@ManyToMany</code> in Produtos Entiy
  - Then hibernate auto-created a relationsip table for union the tables
  
9/2/19  
Resolving some problens of reference ciclic
  - Using <code>@JsonManagedReference</code> and <code>@JsonBackReference</code>
  
10/2/19  
Adding Cidade and Estado domain
  - Create entities Cidade and Estado
  - Create endPoint <code>/estados/</code>
  - Using <code>@OneToMany</code> and <code>@ManyToOne</code> to relation the domains
    
Let's introducing new domains like <code>Endereco</code> and <code>Cliente</code>  
   - Create entities Cliente and Endereco
   - Create rest service to expose information of Cliente and Endereco as like as yours relationship
