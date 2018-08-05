# 使用Java操作excel
# 1.1 可选方案：poi , jxl

|       item      |           poi               |     jxl       |
|---------------- |-----------------------------|---------------|
| support version | Excel 95, 97, 2000, XP,2003 | Excel 97-2008 |

# 1.2 poi official website
> https://poi.apache.org/

poi 框架提供的三种方式比较：HSSF、XSSF、SXSSF
临时文件：
>> Windows7： C:\Users\username\AppData\Local\Temp
--- 
>> Linux： /var/tmp/

|      Item       |       HSSF      |     XSSF        |        SXSSF      |
|---------------- |-----------------|-----------------|-------------------|
| support version |   Excel97-2003  |    Excel2007+   |    Excel2007+     |
| extension name  |    .xls         |    .xlsx        |      .xlsx        |
|    feature      |                 |                 | POI3.8版本,低内存占用 |

# 1.3 Excel version instruction

|      Version    |   Excel97-2003   |   Excel2007   |
|-----------------|------------------|---------------|
|    Max rows     |      65536       |    1048576    |
|   Max columns   |       256        |     16384     |
|  compatibility  |   不能打开.xlsx    |   可以打开.xls  |
