import requests
from bs4 import BeautifulSoup
import re
import pymysql
import time

headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36",}

def getHtml(url):  # 获取每个页面
    req = requests.get(url, headers=headers)
    req.encoding = 'utf-8'
    html = req.text
    soup = BeautifulSoup(html, 'html.parser')

    main = soup.find('article',attrs={'class':'box article'})
    if 'gaokaofuxi' in url:
        items = main.find_all('article', attrs={'class': 'list-item nofocus'})
    else:
        items = main.find_all('article',attrs={'class':'list-item'})  # list-item 普遍  list-item nofocus 高考复习
    hrefs = re.findall('<h4><a href="(.*?)"',str(items))
    print('hrefs爬取成功')
    return hrefs

def getNextHtml(href,subject,password,port):    # 爬取下一级网页
    n = 1
    for i in href:
        reqNext = requests.get(i)
        reqNext.encoding = 'utf-8'
        htmlNext = reqNext.text
        soupNext  = BeautifulSoup(htmlNext, 'html.parser')
        print(subject,"的第",n,"个下级网页爬取成功")
        n = n+1
        mainNext = soupNext.find('article',attrs={'class':'box'})  # 获取下一级网页的主要框架内容
        list = []
        titleNext = mainNext.find('h1',attrs={'class':'article-title'}).text   # 获取文章标题
        timeNext = mainNext.find('time',attrs={'class':'item'}).text  # 获取文章时间
        contentNext = mainNext.find('div',attrs={'id':'article_content'})  # 获取文本内容，未清洗
        list.append(titleNext)
        list.append(timeNext)
        list.append(contentNext)
        saveSql(list,subject,password,port)

def saveSql(data,subject,password,port):
    db = pymysql.connect(host='localhost', user='root', passwd=password, database='team01all',port=int(port))
    cursor = db.cursor()
    sql = "INSERT INTO gaokaozixun(zixun_title,zixun_time,zixun_content,zixun_type,createdate) VALUES (%s,%s,%s,%s,%s)"
    try:
        cursor.execute(sql,((data[0],data[1],data[2],subject,time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()))))
        db.commit()
        print('导入数据库成功')
    except:
        print('发现错误')
        db.rollback()
    db.close()

def main():
    dict = {'高考政策': 'gaokaozhengce', '高考新闻': 'xinwen', '高考分数线': 'gokaofenshuxian',
            '录取查询': 'luquchaxun', '高考状元': 'gaokaozhuangyuan','高考大纲':'gaokaodagang',
            '成绩查询':'chengjichaxun','高考报名':'gaokaobaoming','高考时间':'gaokaoshijian','高考体检':'gaokaotijian'}
    print('爬取就上高考网_高考资讯专栏')
    print('请确保数据库中存在"ziliao"表')
    port = input('请输入数据库端口号,如"3306":')
    password = input('请输入数据库密码:')
    for m, n in dict.items():
        for i in range(1,8):
            print('-'*50)
            print('开始爬取',m,'的第',i,'个网页')
            url = 'https://www.93gaokao.com/'+n+'/list_' + str(i) + '.html'
            hrefs = getHtml(url)
            getNextHtml(hrefs,m,password,port)
            print(m,'的第',i,'个网页爬取完成')
        time.sleep(0.5)
        print(m,'爬取完成')

main()
