# AirClass
DIST信管在线学习平台


用户端API文档

登陆

1.请求地址:  /POST  https://a.iwakeup.cn/login    

1.1请求参数

  请求参数    	类型    
  userid  	String
  password	String

1.2返回参数

  返回参数  	类型    	状态               
  msg   	String	未找到用户 / 密码错误 / 成功
  code  	int   	-1 / 0 / 1       
  state 	int   	200              
  result	String	code=1时返回        

1.3 返回数据

成功:

    {
    	"msg":"成功",
    	"code":1,
    	"state":200,
    	"result":{
    		"username":"胡敏",
    		"userid":"1606010204",
    		"password":"humin147",
    		"major":"信息管理与信息系统",
    		"school":"大连科技学院",
    		"classes":"2"
    		
    	}
    
    }

未找到用户:

    {
    	"msg":"未找到用户",
    	"code":-1,
    	"state":200
    }

密码错误:

    {
    	"msg":"密码错误",
    	"code":0,
    	"state":200
    }



注册

1.请求地址:  /POST  https://a.iwakeup.cn/register

1.1请求参数

  请求参数    	类型    
  userid  	String
  username	String
  password	String
  major   	String
  school  	String
  classes 	String

1.2返回参数

  返回参数 	类型  
  msg  	成功  
  code 	1   
  state	200 

1.3返回数据

    {
    "msg":"成功",
    "code":1,
    "state":200
    }



加载视频

1.个人文档

1.1 请求地址:  /GET   https://a.iwakeup.cn/video

1.2 无请求参数

1.3返回参数

  返回参数 	类型       	状态        
  msg  	String   	成功 / 未找到文件
  total	int      	视频个数      
  code 	int      	1 / 0     
  state	int      	200       
  video	JsonArray	code=1时返回 

1.4 返回数据

成功:

    {
    	"msg":"成功",
    	"total":1,
    	"code":1,
    	"state":200,
    	"video":[
    		{
    			"content":"测试",
    			"objectid":118,
    			"title":"测试",
    			"url":"http://dxb.iwakeup.cn/test2.mp4"
    		}
    	]
    }

未找到文件:

    {
    	"msg":"未找到文件",
    	"code":0,
    	"state":200
    }

加载试卷

1.请求地址:  /POST   https://a.iwakeup.cn/paper

1.1返回参数

  返回参数 	类型       	状态         
  msg  	String   	成功 /  未找到文件
  total	int      	试卷数量       
  code 	String   	1 / 0      
  state	String   	200        
  paper	JsonArray	code=1时返回  

1.2 返回数据

    {
    	"msg":"成功",
    	"total":3,
    	"code":1,
    	"paper":[
    		{
    			"code":"1517296746984",
    			"content":"单元测试",
    			"fillblank":1,
    			"objectid":268,
    			"singlechoice":1,
    			"title":"单元测试",
    			"tof":1
    		},
    		{
    			"code":"1517294312863",
    			"content":"单元测试2",
    			"fillblank":1,
    			"objectid":278,
    			"singlechoice":1,
    			"title":"单元测试2",
    			"tof":1
    		},
    		{
    			"code":"1517292457656",
    			"content":"单元测试1",
    			"fillblank":1,
    			"objectid":350,
    			"singlechoice":1,
    			"title":"单元测试1",
    			"tof":1
    		}
    	],
    	"state":200
    }

未找到文件:

    {
    	"msg":"未找到文件",
    	"code":0,
    	"state":200
    }



加载个人文档和分类

1.个人全部文档

1.1请求地址:   /GET  https://a.iwakeup.cn/docbyuserid

1.2请求参数

无参数要求，但是必须先请求登陆(https://a.iwakeup.cn/login)

再请求使用个人文档(https://a.iwakeup.cn/docbyuserid)

1.3返回参数

  返回参数 	类型       	状态         
  msg  	String   	成功 /  未找到文件
  total	int      	文档数量       
  code 	String   	1 / 0      
  state	String   	200        
  doc  	JsonArray	code=1时返回  

1.4返回数据：

    {
    	"msg":"成功",
    	"total":3,
    	"code":1,
    	"doc":[
    		{
    			"filename":"16-2_胡敏_信息管理与信息系统专业认知导论报告.doc",
    			"filenametime":"16-2_胡敏_信息管理与信息系统专业认知导论报告.doc",
    			"fileurl":"http://static.iwakeup.cn/16-2_胡敏_信息管理与信息系统专业认知导论报告.doc",
    			"groupid":0,
    			"objectid":1,
    			"userid":1,
    			"username":"2"
    		},
    		{
    			"filename":"信二大学生创业训练申请表.doc",
    			"filenametime":"信二大学生创业训练申请表.doc",
    			"fileurl":"http://static.iwakeup.cn/信二大学生创业训练申请表.doc",
    			"groupid":15,
    			"objectid":2,
    			"userid":1,
    			"username":"2"
    		},
    		{
    			"filename":"第九章 CSS样式表1--选择器.pptx",
    			"filenametime":"第九章 CSS样式表1--选择器.pptx",
    			"fileurl":"http://static.iwakeup.cn/第九章 CSS样式表1--选择器.pptx",
    			"groupid":15,
    			"objectid":5,
    			"userid":1,
    			"username":"humin"
    		}
    	],
    	"state":200
    }
    
    

未找到文件:

    {
    	"msg":"未找到文件",
    	"code":0,
    	"state":200
    }



2.文档分类

2.1请求地址：/GET  https://a.iwakeup.cn/alldocgroup

2.2无请求参数

2.3.返回参数

  返回参数    	类型    	状态         
  msg     	String	成功 /  未找到文件
  total   	int   	文档分类数量     
  code    	String	1 / 0      
  state   	String	200        
  docgroup	String	code=1时返回  

2.4返回数据

    {
    	"msg":"成功",
    	"total":2,
    	"code":1,
    	"state":200,
    	"docgroup":[
    		{
    			"groupname":"数据结构文档",
    			"notification":"星期我之前提交",
    			"objectid":14
    		},
    		{
    			"groupname":"测试作业",
    			"notification":"测试作业",
    			"objectid":15
    		}
    	]
    }

未找到文件:

    {
    	"msg":"未找到文件",
    	"code":0,
    	"state":200
    }

加载个人分类文档

1.请求地址:   /GET https://a.iwakeup.cn/getdocbyuseridandgroupid

1.1请求参数

必须先请求登陆

  请求参数   	类型    
  groupid	String

2.返回参数

  返回参数 	类型       	状态       
  msg  	String   	成功 / 非法参数
  total	int      	文档数量     
  code 	int      	1 / -1   
  state	int      	200      
  doc  	JsonArray	code=1时返回

2.1返回数据

    {
        "msg":"成功",
        "total":2,
        "code":1,
        "doc":[
            {
                "filename":"信二大学生创业训练申请表.doc",
                "filenametime":"信二大学生创业训练申请表.doc",
                "fileurl":"http://static.iwakeup.cn/信二大学生创业训练申请表.doc",
                "groupid":15,
                "objectid":2,
                "userid":1,
                "username":"2"
            },
            {
                "filename":"第九章 CSS样式表1--选择器.pptx",
                "filenametime":"第九章 CSS样式表1--选择器.pptx",
                "fileurl":"http://static.iwakeup.cn/第九章 CSS样式表1--选择器.pptx",
                "groupid":15,
                "objectid":5,
                "userid":1,
                "username":"humin"
            }
        ],
        "state":200
    }

删除个人文档

1请求地址：/GET https://c.iwakeup.cn/api/delUserFile

  请求参数    	类型    
  objectid	String

1.2返回参数

  返回参数 	类型    	状态       
  msg  	String	成功 / 非法参数
  code 	int   	1 / -1   
  state	int   	200      

1.3返回数据

    {
    	"msg":"成功",
    	"code":1,
    	"state":200
    }

加载个人成绩

1.请求地址 /GET https://a.iwakeup.cn/getscorebyid

1.1无请求参数

必须先请求登陆

1.2无返回参数

直接返回如下JSONObject

1.3返回数据

    [
    	{
    		"objectid":1,
    		"paperid":350,
    		"papertitle":"计算机组成原理",
    		"score":"100",
    		"userid":1,
    		"username":"胡敏"
    	},
    	{
    		"objectid":2,
    		"paperid":268,
    		"papertitle":"数据结构",
    		"score":"90",
    		"userid":1,
    		"username":"胡敏"
    	}
    ]

未找到成绩

    null或者{}


