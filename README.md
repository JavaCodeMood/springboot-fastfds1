fastdfs
-
源码： GItHub地址：https://github.com/happyfish100

文件上传后的路径：    
group1/M00/00/43/wKgCYVwhkTOAUxZ1AGf8LohRDBw966.jpg    
解读：    
一、组名：文件上传后所在storage组名称，在文件上传成功后有storage服务器返回，需要客户端自行保存。     

二、虚拟磁盘路径：storage配置的虚拟路径，与磁盘选项store_path*对应。如果配置了store_path0则是M00，如果配置了store_path1则是M01，以此类推。    

三、数据两级目录：storage服务器在每个虚拟磁盘路径下创建的两级目录，用于存储数据文件。    

四、文件名：与文件上传时不同。是由存储服务器根据特定信息生成，文件名包含：源存储服务器IP地址、文件创建时间戳、文件大小、随机数和文件拓展名等信息。    

