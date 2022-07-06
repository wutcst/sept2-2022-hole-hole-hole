# 实训报告

> 组别：hole hole hole 
>
> 姓名：杨灿，林冠成，马必争，刘磊（排名不分先后）
>
> 学院：计算机与人工智能学院
>
> 学号：0121910880101，0121914660103，0121910880132，0121920390220，
>
> 班级：软件1903
>
> 任课教师：唐祖锴

***\*注：小组共同撰写的实践报告，由每个成员独自撰写后拼接而成，其实践任务平均分配，实践报告每人20页左右。\****



# 1.任务概述

## **1.1** 任务内容

(1) 创建软件开发小组

​		每个开发小组人数3-5人，推选一人作为组长，负责组织、协调和领导团队开发；

​		重点：所有小组成员应按操作步骤在github开发平台上加入同一小组，共用同一代码仓库；

 

(2) 针对样例代码工程进行小组讨论，确定功能扩充需求点

​		样例工程“world-of-zuul”具备最基本的程序功能，该项目具有极大的扩展空间。

​		重点：开发小组内可进行沟通讨论，确定系统结构优化需求或功能扩充需求，结构优化或功能扩充项不能少于5项；

 

(3) 基于Github中的issue管理功能明确工作任务并为组员分配工作任务

​	重点：

* 将工作任务拆分细化后，明确版本开发计划和里程碑时间节点；

* 在github平台创建任务issue并为所有组员分配任务；

* 每位组员分别承担开发、测试、集成等工作任务；

 

(4) 基于小组商定的分支模型进行软件功能开发，并按开发流程进行代码测试、提交、归并和同步

​	重点：

* 小组成员按照小组商定的分支模型在各自的工作分支进行进行开发任务；

* 工作分支在合并前同步到远程仓库供教师检查每人的开发工作完成情况；

* 提交代码时应按照小组约定的规范格式填写代码提交说明

 

(5) 代码提交到远程仓库后，应进行自动化代码格式规范检查和测试以确保功能符合需求设计

​	重点：

* 利用actions功能在代码提交时自动触发代码格式检查；

* 利用actions功能在代码提交时自动触发测试用例检查；

 

(6) 完成前述各项任务后，可尝试进行代码自动化打包，自动生成可供执行的jar文件

​		结合github平台的actions功能和maven编译脚本，在代码通过规范性检查和测试用例后，进行自动化打包，生成可供直接执行的jar文件用于系统发布。

​		重点：规范性检查和测试用例后，进行自动化打包。

 

## **1.2** 任务目的

(1) 巩固强化软件编程规范

(2) 提高面向对象软件建模与抽象能力

(3) 培养小组协同开发能力

(4) 掌握基于Maven的软件项目管理机制

(5) 掌握基于Github的小组协同开发工具和平台

(6) 了解DevOps软件开发流程

 

# **2** 任务分析

​		样例工程代码 world-of-zuul 是一个基于字符界面的探险游戏，这个游戏目前只具备一个基本的功能框架，需要我们对其进行完善和扩充。所以，当我们拿到样例工程代码时，可用发现zuul游戏这个版本是很无聊的，不过它提供了一个很好的基础设计和实现我们自己的游戏，接下我就对这次任务进行一个分析，共5点：

## **2.1** 工作重点

​		本次的实验是小组合作进行的，所以若想将该项目扩展成一个高质量的项目，必须合理规划小组任务合作开发、对项目的整个软件开发生命周期，如架构设计、项目设计、迭代开发、测试进行良好的规划以及开发过程中的项目管理与版本管理等，基于此，以下是我们小组成员对此实践任务的工作重点：

### 2.1.1合作开发

​		基于《软件工程实践一》中完成的项目基础，以小组为开发单位，采用迭代递进的实践过程中逐步掌握课程内容。合理的进行小组软件过程开发，是保证项目高效率、高质量完成的重要保障。因此，针对我们小组四人进行开发阶段划分、项目管理平台的搭建与使用、开发任务的分派与跟踪，是我们合作开发的实践重点。

​		**前端：**

​		* 前端界面设计，根据功能需求设计主页面的布局

​		* 根据想要实现的效果确定数据展示的方法

​		* 确定所要展示数据的格式以便于与后端交互

​		* 前端调用后端实现的接口进行交互。

​		* 利用接口测试工具对前端所需接口进行测试

​		**后端**：

​		* 后端设计接口，根据功能需求设计相应的代码逻辑并提供访问接口。

​		* 整体架构设计

​		* 代码开发

​		* 编写接口，前后端对接

​		* 后续进行测试、部署、发布

​		小组四人的合作划分情况如表1所示：

| **成员** |        **任务分派**        | **完成情况** |
| :------: | :------------------------: | :----------: |
|   杨灿   | 界面设计及游戏界面前端开发 | 高质量完成√  |
|  马必争  | 界面设计及游戏界面前端开发 | 高质量完成√  |
|   刘磊   |     后端分层开发及测试     | 高质量完成√  |
|  林冠成  |     后端分层开发及测试     | 高质量完成√  |

​		**涉及工具：**

​		*  Github小组管理

​		*  Github Issues任务分配

​		*  Github DevOps软件开发

​		*  各成员开发内容相关的实践工具

### **2.1.2** **软件生命周期开发流程**

​		我们将按照软件开发生命周期的整个流程来进行world-of-zuul游戏开发，指导我们实现一个架构优良、扩展性强、可维护性高的优质项目。

​		(1) **需求分析**

需求分析我们主要讲述项目指定的功能需求以及我们额外添加的系统需求：如用户模块、系统设置等。

​	    **用户模块：**

​		需求：实现用户登录与注册。

​		描述：我们希望做的是一个实时的多人用户游玩的洞穴探险游戏，所以需要玩家进行用户注册，且只有经历过登录的玩家才可以游玩我们的游戏，这也是为了以后多人游戏、网络游戏打下了基础。

​		界面原型：

![image](https://user-images.githubusercontent.com/71442142/177562433-4cc7b819-9616-47f6-877a-b87fd41c53bd.png)															**图1** **用户登录与注册原型图**

​		**玩家模块（游戏界面）**

​		需求：项目指定的功能需求以及我们扩展的需求。

​		描述：在玩家模块中，我们完成了所有的8条功能，即基础的5个功能外，还实现了：

​		a. 扩充游戏基本架构，支持网络多人模式，具备玩家登录功能。

​		b. 增加可视化的图形化用户界面，通过图形化界面执行游戏功能。

​		c. 为游戏增加数据库功能，用于保存游戏状态和用户设置。

​		d. 增加了多种游戏实体，使游戏更具可玩性，如财宝、武器、怪物等。

​		e. 相应的增加玩家操作：装备武器、攻击怪物、获取金币等。

​		f. 用户系统操作：手动存档、刷新地图、退出游戏、查看所有玩家等。

![image](https://user-images.githubusercontent.com/71442142/177562855-02576722-4221-4256-9350-b21afe025bd1.png)

​		界面原型：

![image](https://user-images.githubusercontent.com/71442142/177562968-7ca9fc97-65ba-4796-a408-68442b0c73ca.png)

​																	**图2** **玩家模块原型图**

​		(2) **架构设计**

​		本项目为前后端分离的Web游戏应用，使用网络应用程序体系结构中的B/S架构。如图3所示：

![image](https://user-images.githubusercontent.com/71442142/177563192-9825a857-1731-4e44-a830-bfc51d5b81e4.png)

​																		**图3** **前后端分离示意**

​		具体技术栈如图4所示：

![image](https://user-images.githubusercontent.com/71442142/177563444-29b743e4-e8d2-4951-a806-2dfae5dae789.png)

​																	**图4** **项目技术栈**

​		**技术选型：**

​		 前端：Vue

​     	后端：Java

 

​		**物理架构设计：**

​		物理架构：整体采用B/S架构实现，浏览器发送请求，后端处理逻辑。

​		项目部署系统：Linux CentOS 7.2

​		应用服务器：Tomcat 9.0.4 (Apache)

​		数据库服务器：MySQL 5.9.1 ; Redis 3.2.1（采用MySQL服务器管理用户数据，Redis管理玩家数据）

​		简易交互逻辑如下图5所示：

![image](https://user-images.githubusercontent.com/71442142/177563940-9a7ea242-5268-445c-a2d7-e050285dfeaa.png)

​																**图5** **前后端交互逻辑**

​		**逻辑架构设计：**

​		分层结构：视图层--->控制层--->业务层--->持久层--->数据库

​				*视图层：用户交互界面

​						登录界面

​						游戏界面等

​				*控制层：处理前端请求，控制业务逻辑

 					   用户登录

​						用户注册

​						玩家行为等

​			   *业务层：处理业务逻辑

​						拾取物品

​						丢弃物品

​						玩家移动等

​				*持久层：和数据库交互

​						玩家CRUD

​						用户CRUD

​				*数据库：数据持久化存储

​						Redis存储玩家数据

​						MySQL存储用户数据

​		 具体逻辑架构设计如图6所示：

![image](https://user-images.githubusercontent.com/71442142/177564638-c631dc92-5e3f-47a3-aed2-e55e197e3c2e.png)

​																**图6** **逻辑架构设计**

​		(3) **项目设计**

​		项目设计主要分为：物理模型设计、逻辑模型设计、界面设计与算法设计。

​		**物理模型设计**

​		物理模型设计即表和实体类的设计，在world-of-zuul中我们设计了多种实体，如：User用户类，Player玩家类，Item物品抽象类，Food食物类，Treasure财宝类等。

![image](https://user-images.githubusercontent.com/71442142/177564978-41079fbc-050b-4ee9-9bea-ef56c721e2ca.png)

![image](https://user-images.githubusercontent.com/71442142/177565047-a4f33826-128c-4d3d-ae5a-0fbc336e7a0e.png)

​														**图7** **实体类所在包结构**

​		**逻辑模型设计**

​		逻辑模型设计即使用软件工程中多种UML图进行项目结构描述，主要包括用例图、类图、时序图等，本次项目我们也打算绘制相应的逻辑模型描述项目结构。

​		用例图，如下图8所示：

![image](https://user-images.githubusercontent.com/71442142/177565335-44b4ea52-594f-4000-9d50-1f57b16cc00d.png)

​															**图8** **world-of-Zuul用例图**

​		类图：以玩家模块的类图为例

![image](https://user-images.githubusercontent.com/71442142/177565579-5760d718-723b-4353-9f4d-fb395ab46d1c.png)

​																	**图9** **玩家模块的类图**

​		时序图：以用户登录的时序图为例 

![image](https://user-images.githubusercontent.com/71442142/177565891-7937238b-7ea1-4a9c-b0ed-856c4ceb6aa9.png)

​															**图10** **用户登录时序图**

​		**界面设计**

​		用户登录界面设计：

![image](https://user-images.githubusercontent.com/71442142/177566144-f3f04ca0-b8ac-4d89-ab18-426908325f56.png)

​															**图11** **用户登录/注册界面**

​		玩家游戏界面设计：

​				* 可视化的在线游玩、

​				* 丰富有趣的场景交互

![image](https://user-images.githubusercontent.com/71442142/177566376-a47a6f35-1dea-4d27-9561-161495137299.png)

​																		**图12** **游戏界面**

​		(4) **搭建开发环境**

​		前端：创建前端项目，Vue环境的初始配置，导入相关包、配置项以及组件库。

​		后端：创建后端项目，相关Maven依赖，配置文件，添加公共类，分配包结构以及其它资源。

​		(5) **编码实现**

​		前端：遵循规范，两人合作开发，调用API，与后端对接

​		后端：遵循规范，两人合作开发，写API接口，与前端对接

​		(6) **测试——迭代**

​		前端：使用API Fox 进行后端Controller接口测试，拉取Swagger API 文档，API调试、API Mock、API自动化测试。

​		后端：后端自己编写Swagger API文档进行Controller接口测试；使用SpringBoot Test，进行JUnit单元测试，测试Service层。

​		编码与测试是迭代交替进行。

​		(7) **部署试运行**

​		将发布版本通过actions的自动化部署，上传Docker镜像，之后服务器上拉取镜像进行部署。

### **2.1.3** **版本管理**

​		这次实践是小组合作进行的，不再是独自开发，所以在使用Git作为版本管理工具时，我们要遵循DevOps软件开发流程，掌握基于Github的小组协同开发工具和平台，能够熟练的掌握Git与GitHub的使用。版本管理的具有很多的重要性，有如下多条：

* 代码版本管理的目的：规范软件产品版本升级流程，清晰管理版本号，加强不同版本软件保存的可靠性。

* 作为数据备份：这是一个主要的功能。因为有代码版本管理，可以有效、清晰的管理副本。

* 版本管理，避免版本管理混乱：最主要的功能，我们可以通过版本管理，明确的知道各个版本代码的修改时间，修改内容日志，并且能够比较查看不同版本之间的异同，恢复到之前的任一版本。

* 提高代码质量：可以将无用的代码(僵尸代码)直接删除，因为修改记录存在代码版本管理工具中。

* 提高协同、多人开发的效率。

* 明确分工责任等等。

### **2.1.4** **项目管理**

​		在软工实践一中，因为工程量很少，整个程序可能就一个模块，几个类就能够实现功能。我们过于专注功能实现，不会特意把项目模块化划分，就专注于一个模块进行开发。但如果我们进入一个很大的工程项目中开发，一个工程有成百上千的模块，有成千上万的类时，类与类的关系，模块与模块的关系，包与包之间的关系，我们应该如何面对呢？很明显，人工手动管理是低效率且极容易出错的，尤其是工程是一个很大的团队，多人共同开发。

​		基于上面可能的情况，软件开发中是有专门的项目管理工具的，它的主要益处是可以大大提高项目管理的全面性。利用这次软件实践，我们应该熟悉使用合适的项目管理工具，学会管理各种模块、包之间的依赖，从而提高我们在开发阶段中的开发效率，或者是团队合作，提高我们团队之间的协作。具体的本次使用的项目管理工具及其作用和优势将在下面工具使用方案和开发计划中讲述。

### **2.1.5** **代码规范**

​		代码规范在研发项目团队中有着重要的作用，因为统一代码规范，有助于提升代码可读性以及工作效率。它主要包括命名、版式、注释等几个方面，有着多个方面的原则。我认为其有以下几点重要作用:

* 规范代码可以减少bug处理

​		如果代码不规范，出现不规范的异常处理，不规范的对输入输出参数的规范，会总是导致我们的程序出现低级而又繁多的bug。

* 降低代码的维护成本

* 有助于代码审查

* 有助于程序员自身的成长

​		我们很明显可以知道，规范开发最大的受益者就是自己！

## **2.2** **技术方案**

​		本次实践任务选择的是基于生命周期的技术方案。在该方案下，我们需放眼全局，将整个开发过程细分为多个阶段，每个阶段有着不同的开发任务，当所有阶段的任务全部完成后，一个完整的程序软件便开发成功了。

​		本次实践任务的主要内容是小组协作开发，从而进行编码和测试两个部分，编码这部分细分为项目重构编码和扩充功能两个方面：

* 项目重构编码：重构整个项目，使其成为B/S架构，前后端并行开发，前后端对接开发 

* 扩充功能：根据需求，在B/S架构下完成需求并扩展需求，实现一个网络游戏

 

​		测试方面即对扩展或者维护修改的内容进行功能测试，主要是后端Controller层及Service层：

* 功能测试：前后端均可进行Controller层测试，后端通过单元测试实现Service层测试。 

​		(1) 对于样例程序的优化和扩展，我将结合软件设计中的设计原则和设计模式进行优化，遵守面向对象的设计方法，尽量减少代码中的耦合，提高内聚程度。采用模块化的设计，能够保证每一次对功能进行扩展时尽量是采用添加一个功能模块的形式完成，尽量不修改原有的代码，后端主要采用了Springboot、Mybatis、Radis、Mysql、Swagger等框架来对原先的项目代码进行整体优化。将其改造为一个规范的web项目。

​		(2) 采用了Maven工具对项目的整个生命周期进行标准化的，系统化的管理。本次实践中主要是通过Maven对项目依赖进行管理，构造项目整体文件结构，实施软件测试等。

​		(3) 本次实践采用Github进行代码版本管理，遵循迭代开发，通过Github来对团队代码进行维护，对开发流程进行控制，采用issue进行团队任务分工，每一次commit和merge都将会绑定对应任务的issue，通过issue来查看每个人的任务完成情况以及任务进展流程。

​		(4) 遵循标准的编码风格，正确的变量命名方式，采用了Alibaba Java Coding Guideline插件在编码过程中对不规范的书写进行提示，并且在编译器中导入了Google的Java代码风格模板，每次写完一份Java文件就让编译器依照风格模板进行修改，最后采用CheckStyle工具依照谷歌编码规范对代码整体进行检测，将工具指出的所有问题进行修改，保证最后工具检测没有问题。代码检测结束过后又采用SpotBugs工具对代码进行静态检测，检查出代码中可能存在的隐患，并且进行修改。

​		(5) 采用了Junit工具进行单元测试，本次实践中我对所有扩展和优化的代码进行测试，保证所有代码能够通过测试。

​		(6) 在关键的类和controller接口中利用swagger接口编写接口文档说明，前端通过ApiFox导入文档进行相关接口测试以及前后端对接工作。

​		(7) 编写action脚本调用maven相关指令实现代码的自动化测试打包等，调用docker的build和push指令实现镜像的创建和推送，之后再服务端拉去镜像实现代码的自动化部署，采用super linter脚本实现代码的规范审查。

 

## **2.3** **工程实施方案**

​		工程实施方案主要包含准备阶段、开发阶段和测试阶段。

​		**准备阶段：**

​				*实践工程要求的语言基础

​				*相关框架知识

​				*工程的项目管理的准备

​				*工程的代码版本管理的准备

​				*…

​		**开发阶段：**

​				*小组合作开发

​				* 确定开发目标

​				* 开发与集成

​				* …

​		**测试阶段：**

​				* 编写接口测试与单元测试

​				* actions自动规范检查与测试

​		**发布阶段：**

​				* actions的自动打包与发布

## **2.4** **工具使用方案**

​		根据实验要求列举出此次实践任务主要涉及到的工具及其使用方案：

​		**(1) Java编程语言开发集成环境：IDEA**

​		本次样例工程为Java语言编写，所以后端选择目前业界公认良好的Java开发工具IDEA作为此次现目的开发工具。IDEA可以集成Maven，支持很好框架应用，如SpringBoot等，适合Java EE的Web应用开发。

​		idea是一个十分主流的JAVA编译器，本次项目都使用此编译器完成，并且在代码管理上，采用了idea自带的图形化git管理工具，不需要在命令行交互也能十分方便快捷的实现代码的版本控制，如下：

![image](https://user-images.githubusercontent.com/71442142/177568771-170bf0cd-7fac-478f-a7dc-b03ab632bf76.png)

​		如果在提交时使用commit message插件，还能对提交格式进行规范，包括代码改动范围、提交内容短描述、提交内容长描述以及提交绑定issue等，如下所示：

![image](https://user-images.githubusercontent.com/71442142/177568852-5035f257-a579-4137-a1d6-ec04c4eb9a08.png)

​		**(2) 项目管理工具：Maven**

​		Maven 作为项目管理工具简化了项目依赖的管理，易于上手，便于现目升级管理整个项目周期等等优点。

​		Maven就是是专门为Java项目打造的管理和构建工具，它的主要功能有：提供了一套标准化的项目结构，提供了一套标准化的构建流程（编译，测试，打包，发布……），提供了一套依赖管理机制。

![image](https://user-images.githubusercontent.com/71442142/177569049-610acc64-6e19-4ea4-a377-268d8c8c05af.png)

​		上图是Maven规范了Java项目的目录结构，基于这种目录结构，Maven就能够正常的对整个项目进行管理。通过对pom.xml文件的配置就能够实现项目生命周期过程及其相关依赖的管理。

![image](https://user-images.githubusercontent.com/71442142/177569134-fba81fc7-eba0-4711-89e7-29d90e9d26b5.png)

​		**(3) 代码版本管理：Git与GitHub**

​		利用GitHub作为实践平台，git工具支持代码版本管理，基于GitHub的分布式协同软件开发。本次实践任务对git的使用也是极为关键的，需要重点掌握。

​		**(4) Swagger框架**

​		Swagger是一个接口文档生成工具，只需要再对应位置进行相应的标注就能够自动化的生成接口文档，十分适用于前后端并行开发的工作要求，文档能够根据代码（注解）的变化而进行动态更新，并且其支持在线调试的功能，能够实现接口的测试。

![image](https://user-images.githubusercontent.com/71442142/177569275-a2608029-7bcd-4e6d-9bc5-258ea6bd81c6.png)

![image](https://user-images.githubusercontent.com/71442142/177569335-d2d6d64a-746d-4eda-b472-e54cce3d31fc.png)

![image](https://user-images.githubusercontent.com/71442142/177569417-dbe569ee-9b97-414a-8c9e-7540d51f3fb8.png)

​		**(5) Alibaba Java Coding Guideline**

​		这是阿里巴巴的JAVA代码规范指导，能够指出代码中不符合规范的地方，安装插件后默认会自动进行代码提示，也可以手动检测，只需要右键项目名，找到【编码规约扫描】即可。

![image](https://user-images.githubusercontent.com/71442142/177569607-d950f7b1-d56d-4658-90e9-21246591e0cd.png)

​		之后还可以导入谷歌的代码规范配置文档intellij-java-google-style.xml，代码编写完成后只需要右键代码，选中【Reformat code】即可将代码改成谷歌的规范，如下所示

![image](https://user-images.githubusercontent.com/71442142/177569679-45b2f84a-cec6-4f81-a85d-39491940d4a8.png)

![image](https://user-images.githubusercontent.com/71442142/177569729-6998d0e5-3245-48e1-9f6c-1335436389c1.png)

​		**(6)CheckStyle**

​		这是对代码进行风格检测的工具，可以自己选择需要检测的风格，在此我设置成谷歌风格，只需要在编译器下方选中CheckStyle并且允许就能检测代码的风格，并且指出问题，如下：

 ![image](https://user-images.githubusercontent.com/71442142/177570020-5da151d8-cdf3-4886-adf5-18eddd18051d.png)

​		**(7) GitHub中的issue以及action**

​		项目开发中采用issue来指定团队各个成员的分工任务（指定Assignees），要求每位成员在commit以及merge时都绑定对应issue方便后续对各个任务开发流程的追踪，如下所示：

![image](https://user-images.githubusercontent.com/71442142/177570086-11ace88b-b91a-4572-b3c7-8e1f2362f7b7.png)

![image](https://user-images.githubusercontent.com/71442142/177570135-9dbb6f50-882d-467d-a108-82d759023691.png)

​		在项目开发时还在action中编写.yml脚本构建workflow，实现在代码提交或合并到master或dev_master分支时能够执行一套规定的操作，目前已有：代码规范审查、代码编译，测试和打包、构建docker镜像、上传docker镜像以及项目自动化部署至服务器。

![image](https://user-images.githubusercontent.com/71442142/177570281-1606b312-66d1-4c25-b3d4-50597deb0246.png)

​		**(8) 其余工具或框架：**

​				* API Fox：API调试、API Mock、API自动化测试

​				* Visual Studio Code：一款强大的源代码编辑器，具有丰富的扩展插件

​				* Process On：项目原型绘制、UML图绘制

## **2.5** **重难点分析**

​		根据我们从接触任务到完成任务，我们认为的重难点：小组合作开发遵循Dev Ops开发过程及GitHub分支、项目重构、技术栈选择、前后端对接以及测试与发布。

​		**项目整体：**

* 灵活运用Github进行版本管理，遵循分支管理规范，版本控制规范，运用issue进行任务分发，运用action实现代码持续集成。

* 采用Maven管理项目，采用swagger编写前后端交互接口文档，遵循restful接口规范。

* 代码书写风格规范，注释javadoc规范。

* 如何优化项目，使之符合面向对象的设计原则。

* 如何对项目进行扩展，实现新功能。

* 如何编写测试用例，能够对优化和扩展的地方进行单元测试。

​		**小组合作开发遵循Dev** **Op****s开发规范**

​		因为本次样例工程是在github上发布的，一开始接触的便是将样例工程clone到本地git，所以对git命令的掌握是必不可少。其次是小组合作开发，必须遵循Dev Ops开发规范，Issues分配任务、分支合并规范等等，这些需要我们掌握，我们小组也是经过在一起实验和互相讨论学习后，知道如何进行一个良好的分支开发流程，这为我们之后的项目顺利开发奠定了基础。

​		**项目重构**

​		将项目重构为B/S架构，起初就是想将游戏重构为一个网页端的小游戏，在有这个想法后，我们首先根据需求，设计了前端的项目原型图，再根据功能，分配前后端各自的任务，比如主要的功能接口的定义等等。这个过程是我们项目的准备阶段的关键一步，我们也是在考虑了很久后，才最终决定的，可以说，有了目标后，我们的开发时间所占的比例是不高的，一切都比较顺利。

​		**技术栈选择**

​		确定好项目架构，我们随后思考的便是前后端技术栈，因为我们学习广度并不是很深，所以有些方面并没有立马想到很好的技术来解决，就比如后端的玩家怎么存储到数据库中，我们思考了很多，在网上也搜索了很多相关技术，最终知道游戏数据的结构应该存储在非关系数据库中，如主流的游戏数据库MogoDB，或者常用于高速缓存的Redis。因为SpingBoot高度集成Redis的特性，我们最终为了顺利快捷实现，就选择了Redis存储游戏数据，而用户数据相对固定，不常修改，故存储在关系型数据库Mysql中。

​		**分工部分：**

* 如何根据需求设计玩家类，如何正确的存储玩家类，由于采用传统的关系型数据库难以存储玩家类数据，于是采用Redis用键值对存储序列化玩家类字节数组。

* 如何设计物品类使其满足高内聚低耦合，如何保证物品类具有高可扩展性，如何管理物品类中不同物品的属性（比如魔法饼干和面包都是食物但属性不同）。在这里采用物品父类Item，分别设计子类Weapon、Food以及Treasure继承它，不同子类使用不同的枚举类存储这个类中包含物品的各个属性。

* 如何设计用户类，如何对用户数据进行持久化存储，如何对用户密码进行加密，用户登录注册的流程，相应service、controller和DAO类的编写。

* 玩家行为逻辑如何设计，怎样在满足玩家吃、丢、捡和穿行为的同时保证程序整体的高内聚低耦合，如何编写相应的service、controller以及DAO。

​		**前后端对接**

​		若想实现前后端分离，并且实现前后端高效的并行开发，需要提前定好需求，并在开发过程中，前后端要通过API接口文档进行对接。本次项目，因为时间有限，是没有编写详细的需求文档的，只能边开发边规定具体的对接接口，所以后端需要编写详细的接口供自己测试，以及前端调用与测试。在这里，我们后端使用Swagger进行后端接口文档的便捷生成，前端使用API Fox 可拉取Swagger文档并进行测试。

​		**Actions与测试和发布**

​		还有一个难点，就是GitHub的Actions功能，我们按照如Google代码规范编写代码、按照Junit编写Service层的单元测试，通过API Fox生成接口测试分组。最后在代码提交GitHub时，通过actions还得进行代码规范检查、测试以及自动化部署。这些内容，我们以前没有完整的经历过，所以需要我们边学习边探索，这样，我们才能开发出一个高质量的项目

# **3** **开发计划**

## **3.1** **项目遵循的主要管理策略和方法：**

​		考虑到本次项目已经定好了需求且实现代码量与开发周期并不多，是顺序进行的，所以可以使用开发的线性和顺序方法，使用瀑布模型进行管理。

 

## **3.2** **根据实验任务计划的开发计划** 

具体流程如下图：

![image](https://user-images.githubusercontent.com/71442142/177571131-31b49847-82fa-4780-9357-ff190c180817.png)

​		(1) **创建开发小组**

​		使用的软件工程工具：GitHub

​			* 点击小组任务发布地址

![image](https://user-images.githubusercontent.com/71442142/177571324-4a109bd6-3414-4e8b-b8dd-5c025f50045d.png)

​			* 登录、验证、加入classroom

![image](https://user-images.githubusercontent.com/71442142/177571423-bac25dba-c285-4e38-839f-10e620c96e53.png)

​			* 关联自己的名字

![image](https://user-images.githubusercontent.com/71442142/177571531-94d93611-9b0d-4ab0-9c73-151f6e6c244b.png)

​			* 选择自己的小组（或创建）

![image](https://user-images.githubusercontent.com/71442142/177571623-f0fb5d4e-aadc-484b-b192-7eff7711e643.png)

​		(2) **确定开发目标**

​		实现一个多人游玩的可视化的洞穴探险游戏。

​		(3) **分配开发任务**

​		使用的软件工程工具：GitHub

​				* 根据Issues分配小组成员任务，如下图所示：

![image](https://user-images.githubusercontent.com/71442142/177571776-e9d303ba-6e53-4214-a665-f7e0e0226823.png)

​		(4) **分支开发与集成**

​		使用的软件工程工具：前端开发IDE、后端开发IDE、Maven、GitHub

​		主要为GitHub的分支开发与集成如下图所示：

![image](https://user-images.githubusercontent.com/71442142/177571860-2fe82ad9-e34b-4558-a94d-241a49989a9d.png)

​		(5) **自动规范检查与测试**

​		使用的软件工程工具：GitHub

​		使用GitHub的Actions功能，创建相应的actions与CI/CD流程作为代码规范检查、测试用例检查。

​		(6) **自动打包与发布**

​		使用的软件工程工具：GitHub

​		使用GitHub的Actions功能，创建相应的actions与CI/CD流程执行的自动化部署。

##  **3.3** **根据前后端开发计划**

### **3.3.1** **前端**

​		**(1) 登录界面**

​		主要分为以下三个阶段：

![image](https://user-images.githubusercontent.com/71442142/177572194-23b58aaa-3e14-4138-9c91-ae9328baf845.png) 

​		登录界面：表单输入模块、登录注册按钮、Loading动态加载效果组件、背景音乐……

​		注册界面：表单输入模板（自定义校验规则）……

​		路由管理与接口对接：按钮绑定的事件函数调用接口、组件间传参跳转……

​		软件工程工具：Vue、VScode、Element-ui组件库、Router库、Vuex状态管理库……

 

​		**前端项目管理策略和方法：**

​		1、提前确定好全局样式globe.css，编码模式，如utf-8等。

​		2、编写习惯必须一致，如都采用继承式的写法，单样式都写成一行。

​		3、标注样式编写人，各模块都及时标注，标注关键样式调用的地方。

​		4、对页面进行标注，如模块的开始和结束。

 

​		**(2) 游戏界面**

​		**阶段一**：画原型图

​		在确定需求之后根据需求功能画界面原型图，用到的软件工具为processon

![image](https://user-images.githubusercontent.com/71442142/177572439-ff78c890-6d68-479e-a12e-aca7b62d91c5.png)

​		**阶段二：**根据原型图实现静态页面

​		根据阶段一所画的原型图通过代码实现静态页面，所写代码要符合规范。用到的软件工具为PhpStorm

​		**阶段三：**对原型图中不同区域的内容进行填充。

​		确定任务信息，背包信息，“地图”等内容所要展示的数据，以及确定数据的格式，对一些触发按钮绑定一些响应函数。用到的工具为PhpStorm 

​		**阶段四**：根据接口获取数据，并进行展示，实现项目的基本功能。

​		给后端说明想要的数据格式后，给不同的响应写请求来获取数据并进行渲染以实现基本功能。用到的工具为PhpStorm，ApiFox

​		**阶段五**：美化界面，拓展功能

​		在所有基本功能实现后，不仅优化项目的界面等，而且为了游戏更好的体验性增加一些新需求，例如刷新地图，退出等功能。

### **3.3.2** **后端**

​		后端开发主要分为四个阶段：后端基本架构搭建、基本功能实现、前后端接口对接以及后期项目优化和测试。

​		**1**.后端基本架构搭建：**采用Maven进行项目的搭建，引入springboot、mybatis、JDBC、mysql驱动等相关依赖，初步设计好项目的整体分层结构（DAO、Service、Controller）,按照软件设计规范对不同的类进行初步的设计，尽量满足高内聚低耦合、高可扩展性和可维护性，之后按照类的不同层次以及职责范围，对项目包层次进行划分。

​		**2.**基本功能实现：**进行基本的设计之后就开始进行相应的代码实现，在实现过程中依照javadoc注解规范进行相应的注解描述，采用谷歌代码规范进行相应的代码调整，并且在设计完一个基本功能后采用Junit进行相应的单元测试，采用CheckStyle进行规范审查，采用SpotBugs进行代码静态审查，采用postman进行相应的接口测试。每个人开发基本功能时都从dev_master上拉去各自的分支，在完成基本开发后统一进行合并到dev_master分支上。基本功能开发过程中也严格依照每个人各自的issue进行开发，并积极的和对应issue关联。上传时执行相应的action脚本进行自动化的代码测试和打包。

* 构造Game游戏类，作为整个游戏服务器的全局容器，装载着所有玩家共享的房间以及所有在线玩家的信息。

* 构造物品类，将物品的共有属性抽象为Item父类，之后设计不同类型的物品子类继承父类，分别设计子类特有属性，并且采用枚举类存放子类特定对象拥有的属性，方便后续开发工作。同时还构造了怪物类，也作为一种地图的游戏资源，可供玩家交互攻击。

* 构造房间类，作为承载游戏里面房间对象的实体。玩家的所有活动环境均是以房间为主体，Room类与Player类有许多关联的地方，比如一个Player类中有一个当前房间属性和历史房间栈，均关联Room类，所以Room类的设计极为关键，需要为现在或以后的功能设计提供扩展性。

* 构造玩家类，设计玩家类存储方法，设计序列化及反序列化工具类用于将玩家类进行序列化，采用Redis作为项目的玩家数据存储数据库以及游戏缓存管理，将玩家ID以及玩家对象二进制字节流以键值对的形式存入其中。

* 设计用户类，配置Mybatis用于对接Mysql数据库，设计用户DAO进行用户基本CRUD操作，基于DAO设计Service处理登录和注册逻辑，之后设计Controller和前端进行交互，根据前端请求来决定调用什么Service层逻辑，并将数据以规范的前后端数据交互格式返回给前端。在这个过程中采用了Swagger编写接口文档，采用postman测试接口正确性，也采用了junit测试service层逻辑的正确性。

* 设计玩家逻辑，设计玩家类对应的DAO接口，提供对玩家的CRUD操作，基于DAO实现玩家的吃、丢、捡、穿、移动和攻击等动作逻辑Service，并设计对应的Controller给前端返回标准的前后端交互数据，在这个过程中也采用各个工具进行代码的测试。

​		**3.**前后端接口对接：**前端采用ApiFox拉取后端编写的Swagger接口文档，根据接口文档中的详细描述进行同步的前端开发工作，在前后端都将基本功能开发出来后，就进行前后端接口的对接，在这个过程中观察是否出现bug，出现bug就进行问题具体的分析并发布对应issue解决bug，在前后端交互过程中也会发现交互数据不合理的地方，也需要对交互的数据进行修改以适应前端的工作逻辑。

​		**4.**对后续代码进行相应的优化和维护，**对没有充分测试的部分编写单元测试进行详细的测试，也采用postman和ApiFox进行统一的自动化测试，上传后采用action脚本自动部署至云端的Linux服务器中，部署完成后组员也积极对项目进行功能测试，找出bug并进行修复。

# **4**  **软件配置计划**

## **4.1** **文件及版本命名规范**

​		实践任务中，GitHub仓库名为：sept2-2022-hole-hole-hole；项目名为：world-of-zuul，且开过程中均以名作为此次项目与模块名。

### **4.1.1前端文件命名**

![image](https://user-images.githubusercontent.com/71442142/177573221-cee1e779-07c1-4f09-8743-7f8c557cb822.png)

​		由于采用vue框架进行开发，因此文件的命名规范使用vue框架的标准，主要文件介绍如下：

​		node_modules目录：项目依赖的第三方node的包

​		main.js => 项目入口文件

​		App.vue => 项目最原始的根组件

​		router => 项目所有路由存放处

​		components => 项目用到的组件

​		assets => 项目用到的图片类的资源

​		package.json => 第三方模块依赖

​		package-lock.json => package的一个锁文件，确定安装的第三方模块的版本

### **4.1.2后端文件命名**

​		Maven进行项目管理，遵循Maven的统一文件目录结构，以及在pom.xml文件中确定项目的唯一“坐标”，具体如下：

​		如图，maven约定的文件目录结构，具体描述如下：

​		---/src				#根目录

​		------/main     #放你主程序java代码和配置文件

​		----------/java    #你的程序包和包中的java文件

​		----------/resources  #你的java程序中要使用的配置文件

​		------/test  		#放测试程序代码和文件的（可以没有）

​		----------/java    #测试程序包和包中的java文件

​		----------/resources  #测试java程序中要使用的配置文件

​		---/pom.xml  	#maven的核心文件（maven项目必须有）

​		除了约定文件目录结构，我们自己创建的java文件应该放在组织域名倒写的多级包中：cn.lkpttxg.sept2.worldofzuul ,并且以不同的子包名，区别该java代码所属模块以及java代码的功能。

## ![image](https://user-images.githubusercontent.com/71442142/177573621-f760b82e-1301-4948-9835-978189ffbbb2.png)

​		**版本命名规范：**

​		以pom.xml中的坐标值来唯一标识一个项目

​				<groupId>cn.lkpttxg.sept2</groupId>

​				<artifactId>world-of-zuul</artifactId>

​				<version>1.0.0</version>

​		其中，groupId为组织域名倒写：cn.lkpttxg.sept2

​		artifactId为项目或模块名，本项目为：world-of-zuul

​		version为版本号，一般写为x.x或x.x-SNAPSHOT形式

## 4.2 **分支管理规范**

​		**(1)前端**

![image](https://user-images.githubusercontent.com/71442142/177574175-566af93b-1c45-4d40-b466-cd971af94104.png)

​		**(2) 后端**

![image](https://user-images.githubusercontent.com/71442142/177574313-854acd6e-a649-4000-8f07-21cabe8b0f5c.png)

![image](https://user-images.githubusercontent.com/71442142/177574458-170b1632-6e59-4bce-bdae-e0a6bce2c5c3.png)

​																	**Master分支总历程**

## **4.3**分支提交规范

​		本次实践的Git提交规范为模仿 type(scope):subject的提交格式，没有使用工具或者模板校验，靠自觉遵守，格式如下：

​	type : description

* Type类型

​			 fix: 修复bug

​			 add: 新功能

​			 update: 更新

​			 style : 代码格式改变

​			 test: 增加测试代码

​			 revert: 撤销上一次的commit

​			 build: 构建工具或构建过程等的变动

* description

​			description是对本次提交的简短描述。不超过50字符。

​	**(1) 前端**

![image](https://user-images.githubusercontent.com/71442142/177575118-b2d650f3-5708-4460-afc4-ee2b77a1e86c.png)

​	**(2) 后端**

![image](https://user-images.githubusercontent.com/71442142/177575392-f36596d7-84c2-4e24-8d2a-9c6865cdac66.png)

## **4.4** **分支合并规**

​	**(1) 前端**

![image](https://user-images.githubusercontent.com/71442142/177575782-ecbc3a47-bf50-449d-8239-df89f1c0b5ea.png)

​	**(2) 后端**

![image](https://user-images.githubusercontent.com/71442142/177575836-e8cf6de4-fd97-4465-a38f-15c982fb8c24.png)

# **5**  **测试计划**

## **5.1** **测试工具与测试规范**

​	**(1) 测试工具：API Fox、Junit**

* **Apifox**

​		Apifox 是接口管理、开发、测试全流程集成工具，定位 Postman + Swagger + Mock + JMeter。

![image](https://user-images.githubusercontent.com/71442142/177576262-cc5fd407-e82e-46bd-8da7-a0933f8a8d65.png)

​		分组测试如下图所示：

​		我们后端Controller提供的接口共分为四个模块：用户模块、玩家模块、房间模块和系统模块。

​		可以通过Apifox的自动化测试，进行黑盒测试，编写测试分组，从而实现Controller接口的测试。

![image](https://user-images.githubusercontent.com/71442142/177576352-a27cf99c-dd5c-45a9-87a2-8894798b5300.png)

​															**利用ApiFox进行接口管理**

![image](https://user-images.githubusercontent.com/71442142/177576463-87b07133-b7d8-4182-a430-324a5c081271.png)

![image](https://user-images.githubusercontent.com/71442142/177576497-02ae151d-6ef5-49b2-af22-82a37154244d.png)

​															**模块用例自动化测试**

* **Junit**

​		Junit 是一个Java 编程语言的单元测试框架。在测试驱动的开发方面有很重要的发展。

​		环境配置：Maven的pom.xml文件中添加其依赖，具体如下图：

​								<dependency>

​									<groupId>junit</groupId>

​									<artifactId>junit</artifactId>

​									<version>4.11</version>

​									<scope>test</scope>

​								</dependency>

​	**(2) 测试规范：**

* **接口测试的规范**

​		* URL规范：规范地址，url地址含义可读

​		* 采用RESTful规范的接口

​		* 请求信息规范

​		* 响应信息规范

* **单元测试的规范**

​		 *可衡量：单元测试的编写应该是可以用具体的指标衡量的

​		本次实践任务中对新增功能的测试要保证通过率100%，行覆盖率50%

​		新增功能导致的原先代码改变，改变的原先代码也进行可衡量的规范测试。

​		* 独立性：单元测试是独立且互相隔离的

​		一个单元测试只测一个功能方法；单元测试方法不依赖于其它的单元测试。

​		* 规范性：单元测试编写需要符合一定规范

​		对实现类测试而非接口；单元测试是无状态的；覆盖范围应该包括所以功能方法(这里我们主要是对新增功能方法测试)；私有方法通过反射机制或者其它框架测；

## **5.2测试内容**

​		整个测试共分为两个部分。

​		(1) **Controller接口的测试：Apifox**

​		a) **用户模块**

![image](https://user-images.githubusercontent.com/71442142/177577420-e3b86613-fe59-4cb6-8aa4-bf0dd4a42bfe.png)

​		b) **玩家模块**

![image](https://user-images.githubusercontent.com/71442142/177577517-95a32b1c-9815-4cc2-801c-a74880843e14.png)

​		c) **系统模块**

![image](https://user-images.githubusercontent.com/71442142/177577607-07cb4290-602f-4e5a-84b1-040fe00d404f.png)

​		d) **房间模块**

![image-20220706224352897](C:\Users\yc666\AppData\Roaming\Typora\typora-user-images\image-20220706224352897.png)

​		(2) **Service接口的测试**

​		测试内容共分为三个类：

* UserService类测试

* PlayerService类测试

* RoomService类测试

​		以上三个类的单元测试即覆盖了所有的业务逻辑功能。

​		以下对PlayerService类进行测试为例：

​		**测试任务规划：**

* 测试用户登录能否正常进行，输入正确的账号密码能够登录，输入错误能够提示，登录成功后能够读取玩家数据。

* 测试用户注册能否正常进行，输入相关信息能够在数据库中创建对应的玩家类和用户类，输入的用户密码能够顺利的进行MD5加密，新创建的玩家数据能够存入Redis中。

* 测试玩家能否顺利捡起物品，捡起物品时能够进行判断，如果超重不能捡起，如果那个位置没有物品则不能捡起，如果没超重则捡起并且要能够减少负重，背包中需要增加这个物品，如果背包中已经有这个物品则需要将这个物品数量进行增加，并且房间中对应位置的物品删去。

* 测试玩家能否顺利的丢弃物品，丢弃物品时能够增加负重，并且背包中物品数量需要减少，如果背包中这个物品已经是最后一个物品了，则需要在背包中删去这个物品。

* 测试玩家能否顺利的吃物品，如果背包中有这个物品，且这个物品是属于Food类则能够顺利的吃下物品，如果没有这个物品或者这个物品不属于Food类则不能吃，并且需要进行相应的提示，吃下后玩家对应的属性需要增加，背包中的负重需要增加，对应物品的数量需要减少。

* 测试玩家能否顺利的装备物品，如果背包中有这个物品且这个物品属于Weapon类物品，则能够顺利的进行装备，如果这个物品不是属于Weapon类物品，则不能进行装备，且需要进行错误提示。装备上物品后玩家攻击力需要相应的增加，玩家的装备物品属性需要改为装备上的武器，如果玩家原先就已经装备了武器，那么需要把原来装备的武器切换到背包中。

![image](https://user-images.githubusercontent.com/71442142/177577989-50a81861-4609-4f73-a122-749d62caf63c.png)

# **6**  **实施情况**

## **6.1** **小组任务划分（过程管理）**

​		(1) **三次里程碑**

​		**开发计划与里程碑时间点：**

​		a) 第一次：前后端分别进行整体开发环境搭建，然后分配各自任务

​		b) 第二次：前后端实现各自基本单独模块功能，并且进行前后端接口设计，编写接口文档，实现前后端并行开发

​		c) 第三次：完成了大部分游戏要求功能，可将游戏部署至服务器并发布测试

![image](https://user-images.githubusercontent.com/71442142/177578215-5d6d7760-03bc-4977-bce6-5448d6f04061.png)

​		(2) **过程管理**

​		在github平台上创建任务issues，并为所有组员分配任务：在本次实验中，我们共发布了20余次issues，平均每人5次，且均与多次提交记录和合并记录关联，是规范有效开发的。

​		具体Issues发布情况与关联情况如下：

![image](https://user-images.githubusercontent.com/71442142/177578314-646a945f-49bd-4fc9-9e52-c176637920ee.png)

![image](https://user-images.githubusercontent.com/71442142/177578379-97400ed9-3220-4bcc-8c1c-d5ac5d65010f.png)

![image](https://user-images.githubusercontent.com/71442142/177578447-c522ade6-88aa-4bdf-ac26-d5e51578c2ac.png)

​		(3) **前后端同步**

![image](https://user-images.githubusercontent.com/71442142/177578540-92225ed7-6aa7-4b08-9de0-7fe2b3521271.png)

## **6.2物品类**

​		物品类的设计父类为Item，子类为武器类Weapon、食物类Food以及财宝类Treasure，并且采用了枚举类存放特定物品属性，具体类图如下所示：

![image](https://user-images.githubusercontent.com/71442142/177578708-8780275c-5797-47e4-a1a7-ebe3878527af.png)

​		Item将物品的重量、描述、名字以及id抽象出来，Weapon特有属性为武器攻击力和耐久，Food特有属性为对血量、攻击以及生命值的加成，Treasure特有属性为物品价值，三个子类都有各自的枚举类，枚举类中通过attribute属性Map存放各个具体对象的属性。通过这种设计方式就能够很方便的管理各种物品的关系，如果没有设计枚举类，那么每次创建一个具体对象时都需要手动输入物品属性，并且物品数量一多，各种物品的具体属性就难以维护。比如，魔法饼干和面包都属于食物类，但他们是不同的对象，具有不同的属性值，如果每次都用手动输入的方式完成面包和魔法饼干的初始化，那么十分耗时耗力，后期如果需要修改相应属性值将会是一个无比庞大的工程，并且如果手动初始化，那么可能造成输入出错，例如两个物品都是魔法饼干，但却具有不同属性的情况。考虑上述问题，本项目就决定使用枚举类来维护各个具体对象的属性。

## **6.3玩家类**

​		玩家类主要属性如下：

* Id：玩家的id

* name：玩家名字

* money：玩家金钱

* weight：玩家负重

* bag：玩家背包，是个Map，键是物品对象，值是物品数量

* currentRoom：玩家当前所在房间

* oldRooms：玩家历史房间栈，存放了玩家之前经过的房间

* weapon：玩家当前持有武器

* attack：玩家攻击力

* health：玩家生命值

### **6.3.1玩家DAO**

​		玩家类中属性繁杂，除了一些基本类型的属性之外还包含了许多引用数据类型的属性，因此用传统的关系型数据库是几乎无法做到存储如此复杂的数据，因此本项目决定采用Redis数据库通过键值对<玩家id，玩家对象字节数组>存储玩家数据。

​		首先需要采用序列化和反序列化工具类对玩家对象进行序列化：

​		// 序列化

​		baos = new ByteArrayOutputStream();  

 	   oos = new ObjectOutputStream(baos);   oos.writeObject(object);

   	 byte[] bytes = baos.toByteArray();  

​		return bytes;

​		// 反序列化

​		bais = new ByteArrayInputStream(bytes);

   	 ois = new ObjectInputStream(bais); 

 	   return ois.readObject();

​		之后配置Redis用于存储玩家数据：

![image](https://user-images.githubusercontent.com/71442142/177579477-46bb76ca-a915-49e1-ae5a-6270da559cc0.png)

​		调用RedisTemplate对象用于实现键值对的存取和修改，基于这种方式实现玩家的DAO：

![image](https://user-images.githubusercontent.com/71442142/177579543-e46b5f88-a816-4f6a-9a30-1e6b19f2e43f.png)

## **6.4用户类**

​		每个用户都能创建自己对应的玩家，在本项目中，用户是注册生成的，而玩家是用户创建的，具体用户属性如下所示：

* id：用户id，唯一标识属性

* playerId：用户绑定的玩家id

* password：用户密码

* username：用户名

* email：用户的邮箱

### 6.4.1用户类DAO

​		用户类能够很好地用关系型数据库进行存储，因此本项目存储用户数据采用的是Mysql数据库进行存储，具体DAO类采用Mybatis配置Mapper文件自动生成。

​		首先进行数据库和Mybatis的相关配置：

![image](https://user-images.githubusercontent.com/71442142/177579913-8337b427-fe18-4bd6-983a-93b504e0e80a.png)

​		之后创建DAO接口并编写具体Mapper配置文件：

![image](https://user-images.githubusercontent.com/71442142/177579976-111a9434-14f7-4f54-b1c0-26b37571ca24.png)

![image](https://user-images.githubusercontent.com/71442142/177580027-8337da65-8d63-41f3-b5ab-3fac1dde2a22.png)

### 6.4.2用户类Service

​		用户类Service是基于用户DAO实现的，主要实现的功能有注册和登录两个。

​		登录时序图如下所示：

![image](https://user-images.githubusercontent.com/71442142/177580181-9a433cb6-69aa-4c8c-9b92-63d57742815d.png)

​		登陆时首先查找数据库，查看是否有匹配用户名和密码的记录，之后获取玩家的id并且从Redis数据库中读取玩家对象，之后获取玩家的当前房间信息，将玩家的当前房间进行恢复。

​		注册时序图如下所示：

![image](https://user-images.githubusercontent.com/71442142/177580253-f80ae2cf-e8d8-4706-accb-4775af86087f.png)

​		注册时首先查看是否存在同名用户，如果不存在那么就创建用户，创建用户时密码将会使用MD5加密，随后会创建对应的玩家，玩家名是有用户指定，玩家的背包，历史房间栈，当前房间等属性将由系统自动生成并存入Redis数据库中，用户的数据也会存入Mysql数据库中。

### 6.4.3用户类Contoller

​		用户类的Controller主要就是用于和前端进行登录和注册的交互操作，具体接口文档如下所示：

​		登录文档：

![image](https://user-images.githubusercontent.com/71442142/177580452-2c50d0f0-5a61-4c93-9b20-bc52993ffabe.png)

​		注册文档：

![image](https://user-images.githubusercontent.com/71442142/177580525-41bfcdad-955f-46b6-96dc-3fd1b14f7165.png)

## **6.5** **Game类**

​		Game类作为全局游戏：Game可以看作是游戏的初始化与全局容器，里面存放着游戏中的公共地图与所有在线玩家。

* gameMap：所有在线玩家游玩的地图一致，多人交互

* Players：只有正确登录的用户，其玩家才可在线

​		Game作为全局承载着游戏

![image](https://user-images.githubusercontent.com/71442142/177580680-4a58d660-85bc-4547-84b5-7f16fd3a07be.png)

## **6.6** **Room类**

​		Room房间类，作为承载游戏里面房间对象的实体。玩家的所有活动环境均是以房间为主体，Room类与Player类有许多关联的地方，比如一个Player类中有一个当前房间属性和历史房间栈，均关联Room类，所以Room类的设计极为关键，需要为现在或以后的功能设计提供扩展性。

​		具体类结构如下：

![image](https://user-images.githubusercontent.com/71442142/177580803-d414e02a-aae2-4ab6-8ede-d5356472d6f3.png)

### **6.6.1** **RoomController类**

​		RoomController包含向外提供的对房间的信息接口，提供如根据房间id获取房间信息、房间描述、房间下一个房间的信息等。具体类图如下图所示：

![image](https://user-images.githubusercontent.com/71442142/177580910-05a41453-e126-4b74-ad14-dac44d8976c8.png)

​		RoomController类的接口API文档：

![image](https://user-images.githubusercontent.com/71442142/177581018-bbc9bf7d-a336-4690-98f8-d55e3fbadd63.png)

### **6.6.2** **RoomController——获取房间信息**

​		通过房间模块的一个接口进行房间模块的功能的解释示例：

![image](https://user-images.githubusercontent.com/71442142/177581148-a658c370-0ae4-4bf5-917d-1d85ccf16a0e.png)

## **6.7** **Monster类**

​		Monster类是怪物类，玩家可与怪物进行攻击。怪物类的具体属性如下图所示：

![image-20220706225924981](C:\Users\yc666\AppData\Roaming\Typora\typora-user-images\image-20220706225924981.png)

## **6.8** **枚举类消除魔法值**

​		消除魔法值：

​		与上次软工实践一样，我们应保证在调用操作时，不要出现魔法值，且初始化物品等均是可以通过Enum操作的。且由于物品种类原因，我们设计了编号的常量组，以及物品属性初始化的枚举类。

​		枚举：物品及其三个子类、怪物、房间等

​		常量：系统常量、编号常量、响应常量等

​		如下图：

![image](https://user-images.githubusercontent.com/71442142/177581431-8a42a319-2f8d-4769-9771-946230e07d31.png)

​																			**常量**

![image](https://user-images.githubusercontent.com/71442142/177581534-17486ad3-55db-4afe-aebc-fedeae58477d.png)

​																	**响应状态的枚举**

![image](https://user-images.githubusercontent.com/71442142/177581624-bc201bc3-6826-4d3f-a6ba-c745468e60a1.png)

​																	 **Item子类的枚举**

## **6.9** **前后端交互格式**

​		为了方面前后端交互，我们需要规范响应数据的返回标准格式。

![image](https://user-images.githubusercontent.com/71442142/177581750-ae943b13-54f4-470a-8b28-2c4b116e95c7.png)

## **6.10玩家摄取食物**

​		玩家摄取食物时序图如下所示：

![image](https://user-images.githubusercontent.com/71442142/177581893-2809bbed-ee14-4013-93e2-32964fe1ba13.png)

​		玩家在摄取食物时首先会判断这个物品能否食用（是否为Food类对象），如果能够食用就将人物属性进行对应的加成，将人物背包中的物品进行删去，人物的负重也进行相应的修改。

​		接口文档如下所示：

![image](https://user-images.githubusercontent.com/71442142/177581968-44b2f23d-2bb0-43bd-b2d7-b8d9b609d17b.png)

## **6.11玩家捡起物品**

​		玩家捡起物品时序图如下所示：

![image](https://user-images.githubusercontent.com/71442142/177582098-58b403a2-5b14-4b23-80fa-8374b77cca3c.png)

​		玩家在捡起物品时首先判断负重是否超标，如果负重超过范围则无法捡起，如果能够捡起就在背包中加入相应的物品，如果物品不存在就新增键值对，如果物品存在则数量增加，之后玩家的负重也需要相应的减少。

​		接口文档如下所示：

![image](https://user-images.githubusercontent.com/71442142/177582178-b6625c1c-494e-4833-b68a-12b9523c6dcd.png)

## **6.12玩家丢弃物品**

​		玩家丢弃物品的时序图如下所示：

![image](https://user-images.githubusercontent.com/71442142/177582257-dd697e07-043d-4870-a6b9-2adf3e08aaa8.png)

​		玩家丢弃物品会将背包中的物品减少，如果背包中这个物品是最后一个了，那么这个物品直接删去，负重进行相应的增加。

​		接口文档如下所示：

![image](https://user-images.githubusercontent.com/71442142/177582315-6646e40f-9b1f-41d2-a7bc-81b6fdf224ec.png)

## **6.13玩家装备物品**

​		玩家装备物品时序图如下所示：

![image](https://user-images.githubusercontent.com/71442142/177582430-2b2013cd-85da-4cad-b8cb-bd4e126fa7f8.png)

​		装备物品时首先会判断这个物品是否为Weapon类的对象，如果是则将玩家的当前武器替换为对应武器，如果玩家之前有装备武器那么就会将之前的武器替换到背包中，玩家的攻击力会进行相应的改动，负重不会修改。

​		接口文档如下所示：

![image](https://user-images.githubusercontent.com/71442142/177582502-9e804d76-aacc-4642-a129-308ead737f20.png)

## **6.14** **功能——玩家前往另一个房间**

​		**接口url**：GET:/worldOfZuul/player/next/{id}/{direction}

​		**描述：**接收到前端的玩家可视化操作，得到玩家id与玩家要前往的方向（知道玩家当前所处房间），返回下一个房间的信息，且上一个房间压入历史房间栈。（如果进入传送房间，会随机到一个房间）

​		具体响应状态与接口API描述如下图：

![image](https://user-images.githubusercontent.com/71442142/177582630-4c8ffa28-5797-4ba1-b9cc-519551935f45.png)

![image](https://user-images.githubusercontent.com/71442142/177582749-da9a6258-6463-418d-839a-773a7191cb87.png)

​		**该功能时序图：**

![image](https://user-images.githubusercontent.com/71442142/177582811-faba8aa4-1bc7-4a82-9abe-40d0dba60c84.png)

## **6.15** **功能——玩家回到上一个房间**

​		**接口url：**GET: /worldOfZuul/player/back/{id}

​		**描述：**前端点击回退按钮，发起请求带玩家id，根据玩家对象的历史栈，进行弹栈，获取栈顶元素，若没有，提示玩家已是最初始房间，否则进行房间的回退。

​		具体响应状态与接口API描述如下图：

![image](https://user-images.githubusercontent.com/71442142/177582915-32fdb3e5-5341-47a5-82af-0b9e2caf5b1b.png)

![image](https://user-images.githubusercontent.com/71442142/177582968-9391dca1-c0f2-49ce-bf5d-5479fd956bba.png)

​	**该功能时序图：**

![image](https://user-images.githubusercontent.com/71442142/177583083-edf01798-42e3-4533-bafe-603bdfeaf7f1.png)

## **6.16玩家攻击怪物**

​		**接口url：**GET: /worldOfZuul/player/attack/{id}

​		**描述：**玩家点击一个怪物，发起攻击，携带怪物位置参数的攻击请求。后端处理逻辑：

​		1.怪物是否存在

​		2.发起攻击后根据双方攻击计算血量变化

​		3.判断怪物或玩家是否濒死

​		4.若怪物死亡，获得金币

​		5.玩家死亡，游戏重新开始

​		具体响应状态与接口API描述如下图：

![image](https://user-images.githubusercontent.com/71442142/177583211-cdd26e9c-83ac-400f-aa64-d50e7c94875f.png)

![image](https://user-images.githubusercontent.com/71442142/177583275-fb4f0308-af71-446c-9b07-a8eae6ff9ea7.png)

![image](https://user-images.githubusercontent.com/71442142/177583303-01f3a1e7-6d47-4335-bc75-4bb43fd0db19.png)

## **6.17** **玩家退出游戏**

​		**接口url：**GET: /worldOfZuul/player/quit/{id}

​		**描述：**玩家点击退出游戏按钮，服务器移除该玩家。并回到初始界面。

​		具体响应状态与接口API描述如下图：

![image](https://user-images.githubusercontent.com/71442142/177583393-ed8c681e-5f69-4499-a4ea-213b58b189d8.png)

![image](https://user-images.githubusercontent.com/71442142/177583441-831aded6-fa7b-4ca4-99b8-73fb44c4f8d2.png)

## **6.18** **保存玩家信息**

​		**接口url：**GET: /worldOfZuul/settings/save

​		**描述：**玩家点击保存游戏按钮，参数带玩家id，后台将玩家数据持久化的存储到我们的NoSQL游戏数据库中，并最终是持久化到服务器的硬盘数据。玩家下次任何地方登录，都可以直接按照上一次存档来。

​		具体响应状态与接口API描述如下图：

![image](https://user-images.githubusercontent.com/71442142/177583575-0d731b9f-b993-4160-bfb1-f8ee641e0e8f.png)

![image](https://user-images.githubusercontent.com/71442142/177583605-8768e5bf-ac5c-4c03-9034-2dce1a738fbd.png)

## **6.19** **系统功能**

### **6.19.1** **清除在线玩家**

​		清除所有玩家用于将在线玩家移除服务器，可作为服务器维护和版本更新时的维护操作。

![image](https://user-images.githubusercontent.com/71442142/177583733-6cd63099-e3bb-4d3c-9dce-cb524c28ce7d.png)

### **6.19.2** **刷新房间**

​		刷新房间是刷新除玩家所在房间的所有房间，防止玩家过多导致资源空乏。

![image](https://user-images.githubusercontent.com/71442142/177583893-06671fb6-c41d-4af5-a4bc-b99f2cd6a6c3.png)

### **6.19.3** **查看所有在线玩家**

​		查看所有在线玩家可以使管理者明确在线人数。

![image](https://user-images.githubusercontent.com/71442142/177584003-24d764db-cad7-4efd-ad42-d1c23db689e9.png)

## **6.20** **测试**

​		功能测试内容及其细节在前面小节均已详细介绍了，故该小节中，就测试结果具体展示：

### **6.20.1接口测试**

![image](https://user-images.githubusercontent.com/71442142/177584166-8d2e63c4-e47b-4f4c-bfe3-59bfa823d72b.png)

### **6.20.2 单元测试**

![image](https://user-images.githubusercontent.com/71442142/177584271-8ce3151b-504f-48a8-9b14-bd94bc0d59d1.png)

## **6.21** **分支管理**

![image](https://user-images.githubusercontent.com/71442142/177584386-e55985d4-ff19-4f50-a1ee-92a792e68646.png)

![image](https://user-images.githubusercontent.com/71442142/177584442-630ccfc1-af1f-4459-9e4d-08351532a56e.png)

## **6.22** **提交管理**

![image](https://user-images.githubusercontent.com/71442142/177584542-f5b171f9-523e-46b2-8439-0b971507227d.png)

![image](https://user-images.githubusercontent.com/71442142/177584593-a1d9d92d-2bb0-4c62-b13b-41d6a2117d26.png)

## **6.23** 分支合并

![image](https://user-images.githubusercontent.com/71442142/177584700-a764a2b1-742e-4ef9-bf31-f3b3345fe7d3.png)

![image](https://user-images.githubusercontent.com/71442142/177584732-b23abda9-5f7e-42ea-b7a6-38b831fe72b0.png)

## **6.24** Actions的CI/CD流程

![image](https://user-images.githubusercontent.com/71442142/177584908-a823ef8a-925d-4e70-851f-47aa840464e0.png)

![image](https://user-images.githubusercontent.com/71442142/177584953-a4674bd7-0822-434b-b14b-ac196349f8b2.png)

​														**Maven编译workflow**

![image](https://user-images.githubusercontent.com/71442142/177585071-ea5212da-461a-43ef-95ed-9f509ee68872.png)

​															**Docker部署的workflow**

![image](https://user-images.githubusercontent.com/71442142/177585152-6fee7c6c-573f-4bd7-9eb6-6e24b55dcd6b.png)

​															**代码规范检查的workflow**

## **6.25** **项目展示**

![image](https://user-images.githubusercontent.com/71442142/177585267-11550d92-769a-4d27-919d-610da9457449.png)

​																			**登录界面**

![image](https://user-images.githubusercontent.com/71442142/177585338-2b924662-c323-40b3-84e4-525a7f5a7f10.png)

​																		**注册界面**	

![image](https://user-images.githubusercontent.com/71442142/177585438-439e6b86-4fba-44d9-9b3e-55ed23b5fa0b.png)

​																		**登录效果**

![image](https://user-images.githubusercontent.com/71442142/177585533-77a61d66-8899-4e22-868d-df8af12cd542.png)

​																		**主界面**

![image](https://user-images.githubusercontent.com/71442142/177585626-fd946f3f-9622-4266-bbf8-3f8fffd20a74.png)

​																		**物品详情**

![image](https://user-images.githubusercontent.com/71442142/177585750-d25322f2-532e-4449-b683-bc7a4d6b6f08.png)

​																	**Actions执行记录**

# **7**  实施过程问题记录与分析

## **7.1** StackOverFlowException

​		因为Room类中包含了它的四个出口，这是一个HashMap的结果，key为方向，value为对应房间的对象。当前端需要房间信息时，我们需要将房间以Json格式的数据返回给前端，然而对于HashMap的exists这四个出口，则会nested一层一层的嵌套进去json格式化，如果房间地图不是连通的，则Json化是有限的，若是连通的，则无限Json化，导致JVM栈溢出，即内存单元不足。

![image](https://user-images.githubusercontent.com/71442142/177586047-4355f4cf-1b7e-4a0d-8b13-0b85975c9381.png)

​		解决方案：

​		给Room的exists出口属性上方添加注释@JsonBackReference，防止Json格式化循环，导致栈溢出。

![image](https://user-images.githubusercontent.com/71442142/177586144-257b8068-a442-4629-a466-68ba46449f88.png)

## **7.2** **项目自动部署**

​		起初在项目基本功能逐渐开发过程中，前端人员需要进行接口获取测试，需要快速的进行当前后台版本的自动部署到Linux服务器上。所以，在IDEA上将Maven打包后的jar包一键部署是很关键的，我们使用的是Alibaba Cloud ToolKit连接远程Linux服务器，并自动上传jar包到指定target，然后执行Linux脚本。

​		其中，在执行自动会部署中，出现的问题是服务器自动化运行Jar包的脚本出现错误，在经过排查错误原因后发现，原因是因为我的shell脚本是在Windows上编写的，然后上传到Linux上的，其中换行符不一致，导致Linux解析错误。Windows下换行符是\r\n，unix下是\n, 所以这里就多了个r，所以执行脚本是就报找不到这个命令，网上给的解决方式是dos2unix 脚本名称，亲测这个方法不好用

![image](https://user-images.githubusercontent.com/71442142/177586234-dfc96ee3-5692-4efa-ab89-8d303475e28b.png)

​		**解决办法：**vim acc.conf.base,然后执行:set fileformat=unix，然后wq，在次执行脚本报错消失

## **7.3相同物品在背包中被认定为不同物品：**

​		原因是object中默认的equals比对的是两个对象的内存地址是否相同，但是事实上本项目只要是两个物品id相同就认定为相同的物品，所以在此需要重写equals方法：

@Override

 public boolean equals(Object o) {

  if (this == o) { 

  return true; 

 }  if (o == null || getClass() != o.getClass()) {

   return false;

  }

  Item item = (Item) o;

  return id.equals(item.id);

 }

## **7.4无法连接远程数据库：**

​		由于远程服务器有防火墙以及相关的认定机制，所以无法直接连接到数据库，需要在域名后加上一些参数才能成功连接：

​		url: jdbc:mysql://124.222.55.179:3306/worldofzuul?useUnicode=true&useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useAffectedRows=true&allowMultiQueries=true

## **7.5玩家类序列化失败：**

​		原因是可序列化对象中的所有属性也需要能够序列化，所以玩家背包中的物品类也是需要能够序列化的。

## **7.6多人游玩时一个物品可被捡起多次：**

​		多人游玩时理论上一个位置的物品只能被捡起一次。被捡起多次的原因是捡起物品时不是基于位置捡起物品的，所以可能出现捡起了同样物品但不同位置的物品，之后修改为基于位置捡起物品就不会出现这种问题。

## **7.7** **Vue版本及组件库相关问题：**

​		在初始化项目环境时，vue-cli工具自动构建最新的vue3.x版本项目。相比于vue2.x有些许语法和相应的组件库应用发生了改变，例如在配置路由时2.x版本和3.x版本在新建vue实例时引入路由的方式不一致导致路由无效。以下为2.x版本正确的路由引入写法：

![image](https://user-images.githubusercontent.com/71442142/177586843-c6368667-3bf3-41b4-bc38-ba37b18edf3c.png)

## **7.8利用store进行状态管理**

​		考虑到进行登录请求时返回的某些数据可能作为后续组件中调用接口的请求参数，如果每次都在路由跳转时携带参数，将会变得非常麻烦并且在页面刷新后数据会丢失。所以考虑到引入vuex库进行状态管理，在登录时将关键信息保存至缓存中。

![image](https://user-images.githubusercontent.com/71442142/177586931-f0a03bea-28a5-4d9b-9c90-47acece820d0.png)

## **7.9** **修改引入组件样式**

​		由于组件库中的组件会自带样式，如若需要修改则在<style>中写入。如果需要修改某一特定组件的属性，则需要在相应组件一个类名，并通过 <.类名 .组件名__属性名>引用。具体组件的属性可以通过浏览器的检查功能查看css样式。

![image](https://user-images.githubusercontent.com/71442142/177587017-23ce8120-4d2e-4b85-a4a3-d7a829ccada4.png)

![image](https://user-images.githubusercontent.com/71442142/177587050-6f8a4376-a579-4dc9-b82e-5db2d76fe4e5.png)

![image](https://user-images.githubusercontent.com/71442142/177587081-3f47f5b8-72af-4edd-a792-cde0be090ce9.png)

## **7.10** **5\*5布局问题** 

​		在设计游戏地图是需要设计一个5*5的格子，一开始利用flex布局结果并不如意。后面经过查询资料发现了grid布局，Grid布局即网格布局，专门用于实现网格布局，效果也是非常的令人满意。基本属性如下:

![image](https://user-images.githubusercontent.com/71442142/177587209-352094b2-7090-4c17-841a-03e4e9e6b58b.png)

## **7.11** **json数据渲染问题**

​		在获取后端的json数据对提示框进行渲染时，由于返回的是一整个字符串，因此在前端不能对其进行格式规范。解决方法是在后端返回json数据时在其中插入html标签，然后利用vue提供的v-html方法对其进行解析即可按照想要的格式进行渲染。

![image](https://user-images.githubusercontent.com/71442142/177587301-8860a541-278c-4f82-9b09-30666a513b6b.png)

## **7.12跨域问题**

​		由于部署到服务器上面了因此存在跨域问题，浏览器从一个域名的网页去请求另一个域名的资源时，域名、端口、协议任一不同，都是跨域。

​		解决办法：后端引入过滤器Cors-Filter，从而允许跨域请求获取服务器接口服务。如下图：

![image](https://user-images.githubusercontent.com/71442142/177587391-90478592-f9d2-463c-8073-6a0769f219be.png)

# **8**  **任务总结**

## **刘磊总结：**

​		总的来说，这次实践任务耗时接近一周，虽然其中过程比较艰辛，但最终小组还是完成了所有的任务要求，这是也我最大的收获。

​		从刚开始面对实践题目，看到是小组合作，并且需要使用很多种软件工程工具来完成这次实践时，我的内心是比较没有把握的，因为我不怎么清楚如何多人一切在GitHub上进行协作开放，这是我第一次接触的事物，其次的还有Issues的发布和Actions的CI/CD流程的使用。当然，最终我们是成功完成了任务，我也懂得了这些工具的使用。

​		我们小组完成了对“World-of-Zuul”这一简单的应用程序的代码阅读和理解，并在此基础上对项目进行了修正和迭代开发，构建管理以及最终release分发。使用git并基于多分支进行协作开发，使用issue来管理开发需求，同时利用pull request和Github的管理功能来进行代码审查，目标确定。这是一次标准化程度非常高的基于Github的多人软件工程开发实践，因为高度重视过程，小组在合并、提交的执行上都非常讲究流程，在软件工程意义上，Github将管理充分地进行了体现；本次实训中我还学会了创建和使用Maven动态部署Jar包，以及运用checkstyle检查代码格式。此项实践开拓视野，让我意识到软件工具的使用并非高攀不起，而是重在摸索和实践；此外在进行文档、会议记录管理时，通过Github我明白了平时记录的重要性，它在复审环节会派上大用场。收获颇丰。

## **杨灿总结：**

​		本次实践是对软件工程实践一中文字游戏的进一步开发，是基于小组完成的前后端分离Web项目。

​		多人协作开发与个人开发的差别很大，个人开发任务全部自己写不存在合并分支冲突问题。在整个开发过程中，我认为最重要的是沟通交流问题。在分配任务时需要沟通交流各自要完成的任务，使任务尽量的独立，在合并分支时会减少冲突。此外，由于是前后端分离，前后端也要频繁的交流，商定统一的数据格式。

​		虽然这个项目是在上学期的项目基础上，但是命令行与可视化而且是前后端分离的项目是有着很大的区别的，可以说是从头开始的一个项目。从项目开始开发到整个项目完成的这段时间和团队一起发现问题，解决问题，这个过程我们相处非常的融洽，我认为这才是项目顺利完成的原因，一个好的团队才是最重要的。

## **马必争总结：**

​		本次实践是对软件工程实践一中文字游戏的进一步开发，是基于小组完成的前后端分离Web项目。这次实践基于Github Classroom，通过绑定小组创建一个Private Repository远程私人仓库，并clone到本地进行开发。这是一种团队开发模式，个人可以创建自己的不同功能分支并推送、合并，如今一些企业均是基于这种开发模式来实现项目多人开发。

​		对于项目实践所要求的内容，都已完成。以下为完成的总体情况：

​		① 软件项目设计

​		前端项目基于Vue2.x版本开发，通过vue-cli搭建环境。相比于传统原生html页面，利用vue开发有以下优势：

* 可以进行组件化开发, 大量减少代码的编写 更易于理解

* 最突出的优势在于可以对数据进行双向绑定

* 相比传统的页面通过超链接的方式实现页面切换和跳转,vue 使用路由不会刷新页面

* vue是单页面应用,不用每次跳转页面都要请求所有数据和dom ,提高了访问速度和用户体验

* vue-router和vuex作为官方库分别为我们提供了路由管理和状态管理的功能。而且Element-ui组件库提供了我们平时所见到的绝大多数组件，能够最大程序给我们的开发提供便利。

​		为了凸显我们小组预先设想的“洞穴探险”主题，设计了相关标题与背景。

​		② 个人软件过程和项目管理

​		利用vue-cli项目管理工具进行项目管理，同时能够通过package.json文件修改来实现对依赖项的管理。在实际开发之前绘制原型图和开发流程图合理安排开发计划，避免一次性开发任务量过重。利用VSCode、vue框架、vetur插件、element-ui组件库等多种工具实现项目开发。

​		③ 代码版本管理

​		利用vscode集成的git工具与远程仓库建立连接。在每次修改代码后，根据规范简述代码修改。分多次进行提交，若出现错误能够及时进行回退（rollback）。代码的版本提交主要依据事先制定开发计划逐步进行，版本命名以日期作为基准。

​		④ 代码注释和编码规范

​		在本次实践主要基于eslint执行代码规范检查并加以修正。利用的是vscode中的插件eslint，这两个工具在软件工程基础实验中也有用过，但当时只是初步了解。自己编写的代码/注释有诸多不符合规范之处，经过工具检查并加以修正使整个项目基本符合代码编写规范。

​		⑤ 接口测试

​		利用ApiFox导入swagger接口文档，分别对每个接口进行测试，覆盖所有响应码。再利用ApiFox的自动化测试功能，整合测试用例和测试分组进行流程化测试。

​		经验与收获：

​		通过本次实验，对于利用vue-cli进行vue前端项目管理、利用git进行代码版本管理、利用eslint等代码规范检查工具进行规范性约束和检查、基于ApiFox实行接口自动化测试等方面有了进一步的了解与应用。对基于Github开发项目的各规范有了一定的认识和应用。对于Vue的项目结构有了更清晰的认识，认识到其基于组件化开发的优势。同时对项目实际开发过程中的各种组件间关系有了新的认识，这是我们在开发项目的过程中需要考虑的问题。一个项目并不是只需要完成功能就行，还要考虑一系列的性能、结构等问题。总而言之，经过本次实践，更能够了解到开发一整个前后端分离Web项目的不容易。以及项目结构及相应优化的重要性。

## **林冠成总结：**

​		通过这次的实践任务让我进一步深入的理解了GitHub如何进行多人开发的，我也学习了如何使用GitHub中的issue进行任务分配以及利用action进行代码持续集成。在这一次实践任务也是我第一次进行多人前后端分离开发任务，在这个过程中我学会了如何实现前后端同步并行开发，如何利用swagger编写接口文档，如何利用postman测试接口，接口能够遵循restful规范。我也更加深入的理解了如何构建web项目，能够更加熟练的进行后端的开发工作，能够较为熟练的使用spring boot框架、mybatis框架以及Radis数据库等，并且我也学会了如何进行后端开发工作的分工，如果代码出现冲突如何进行解决。总而言之，通过这一次实践课程让我完整的参与了一个前后端分离web项目的开发工作，项目中的各个方面我都参与其中，这个经历让我受益匪浅。

 

 

# **9**  **参考文献**

[1]肖平.计算机软件开发的技术方案[J].电子技术与软件工程,2018(24):30.

[2]朱荣峰.计算机技术在工程项目管理中的应用[J].无线互联科技,2021,18(18):87-88.

[3]何春旺,楼思思.计算机软件的开发能力教学实践[J].电子技术,2021,50(11):260-261.

[4]山中月录.Git详细使用教程，https://www.cnblogs.com/qingmei/p/4120407.html 

[5]李建东.软件体系结构风格、设计模式及其应用[J].电子技术与软件工程,2020(15):72-73.

[6]Vue.js中文文档，https://vuejs.bootcss.com/guide

[7]Element UI 教程，https://element.eleme.cn/#/zh-CN