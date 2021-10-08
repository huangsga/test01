import pymysql

port = input('请输入端口号:')
password = input('请输入密码:')
db = pymysql.connect(host='localhost', user='root', passwd=password, database='team01', port=int(port))
cursor = db.cursor()
sql = 'CREATE TABLE `team01`.`ziliao` (`ziliaoID` INT NOT NULL AUTO_INCREMENT,`title` VARCHAR(300) NULL,`time` VARCHAR(45) NULL,`content` LONGTEXT NULL,`subject` VARCHAR(45) NULL,`createdate` DATETIME(6) NULL,`isdelete` VARCHAR(2) NULL,PRIMARY KEY (`ziliaoID`));'
try:
    cursor.execute(sql)
    db.commit()
    print('创建数据库成功')
except:
    print('创建数据库失败')
db.close()