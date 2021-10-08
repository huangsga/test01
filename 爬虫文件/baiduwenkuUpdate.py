import requests
from bs4 import BeautifulSoup
import re
import pymysql
import time
# -*- coding: utf-8 -*-

head ={'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.128 Safari/537.36',
        'Cookie':'BIDUPSID=598D0AAC1C6E4C065B98E8C41CA6DC0E; PSTM=1562161803; BDUSS=gxN25TeFVGQzBlbldMNFYxRmdxV2NwbmRweFV1T0pGQ0V2dzBYa1BWTzl0b0JlRVFBQUFBJCQAAAAAAAAAAAEAAABJvwVKxbXD17Dgs6QAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAL0pWV69KVleRF; BDUSS_BFESS=gxN25TeFVGQzBlbldMNFYxRmdxV2NwbmRweFV1T0pGQ0V2dzBYa1BWTzl0b0JlRVFBQUFBJCQAAAAAAAAAAAEAAABJvwVKxbXD17Dgs6QAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAL0pWV69KVleRF; H_WISE_SIDS=154599_148078_145999_155425_155392_149355_150074_147089_150084_155224_148867_154763_154606_153715_153427_154374_155415_153066_151016_154950_127969_154175_153571_155327_152902_152982_150345_155318_146732_154603_152571_131423_155491_154038_155396_154990_154190_155344_154791_154952_140312_144966_153665_154438_155689_154619_154118_155663_154802_155237_153953_148423_147547_153987_148869_154302_110085; BAIDUID=0411FB01EA88C3465E9DB70A336F083F:FG=1; tiku_paper_visited=1; __yjs_duid=1_ef20a4cf0f47204f58b1d01540d22e911619424760084; BDORZ=FFFB88E999055A3F8A630C64834BD6D0; Hm_lvt_de54c5cc453c7904719695d12c1a5daa=1620709972,1620728278,1620805244,1620868586; H_PS_PSSID=33984_33817_34004_33855_33607_26350; delPer=0; PSINO=1; BAIDUID_BFESS=0411FB01EA88C3465E9DB70A336F083F:FG=1; BCLID=6215289160493955950; BDSFRCVID=31tOJeC62ZYdcWrewQpwJl-2VmMFvqbTH6aoaN-50iXKrT_5mk_UEG0PSf8g0KubhlIjogKKLgOTHULF_2uxOjjg8UtVJeC6EG0Ptf8g0f5; H_BDCLCKID_SF=fR-f_D_5fIvDqTrP-trf5DCShUFs0f3iB2Q-XPoO3K8WfxOkbJJIylLph2FHLtriWKk8-UbgylRM8P3y0bb2DUA1y4vpKMrJLgTxoUJ2fnI2En7GqtOOe5tebPRiWPb9QgbP2pQ7tt5W8ncFbT7l5hKpbt-q0x-jLTnhVn0MBCK0bDP6j6Kbe5PVKgTa54cbb4o2WbCQ5Inh8pcN2b5oQTJb5RbXKRbGWD3ZWTC-QJ6vOn0w3hOUWfA3XpJvQnJjt2JxaqRC5h6MVh5jDh3Me-cQLUnte43Wfn7y0hvcBn3cShnaXMjrDRLbXU6BK5vPbNcZ0l8K3l02V-bIe-t2XjQhDG8eJ5DtfR4sL-35HtnEHJ7g5tnHMDCShUFsJ5oJB2Q-5KL-yfTfHU34bJJGKb-ph2FHLtru3jcD3fbdJJjoHquzjj3EWMPX3bPt24ndQmTxoUJR5DnJhhvG-47SytIebPRiWPb9QgbP2pQ7tt5W8ncFbT7l5hKpbt-q0x-jLTnhVn0M5DK0HPonHj--j5by3f; BCLID_BFESS=6215289160493955950; BDSFRCVID_BFESS=31tOJeC62ZYdcWrewQpwJl-2VmMFvqbTH6aoaN-50iXKrT_5mk_UEG0PSf8g0KubhlIjogKKLgOTHULF_2uxOjjg8UtVJeC6EG0Ptf8g0f5; H_BDCLCKID_SF_BFESS=fR-f_D_5fIvDqTrP-trf5DCShUFs0f3iB2Q-XPoO3K8WfxOkbJJIylLph2FHLtriWKk8-UbgylRM8P3y0bb2DUA1y4vpKMrJLgTxoUJ2fnI2En7GqtOOe5tebPRiWPb9QgbP2pQ7tt5W8ncFbT7l5hKpbt-q0x-jLTnhVn0MBCK0bDP6j6Kbe5PVKgTa54cbb4o2WbCQ5Inh8pcN2b5oQTJb5RbXKRbGWD3ZWTC-QJ6vOn0w3hOUWfA3XpJvQnJjt2JxaqRC5h6MVh5jDh3Me-cQLUnte43Wfn7y0hvcBn3cShnaXMjrDRLbXU6BK5vPbNcZ0l8K3l02V-bIe-t2XjQhDG8eJ5DtfR4sL-35HtnEHJ7g5tnHMDCShUFsJ5oJB2Q-5KL-yfTfHU34bJJGKb-ph2FHLtru3jcD3fbdJJjoHquzjj3EWMPX3bPt24ndQmTxoUJR5DnJhhvG-47SytIebPRiWPb9QgbP2pQ7tt5W8ncFbT7l5hKpbt-q0x-jLTnhVn0M5DK0HPonHj--j5by3f; ZD_ENTRY=baidu; ab_sr=1.0.0_YzA4NzNlNTExMWVlZTZhYWEwOTMxY2I1MWQxMDM5ODE1Zjk2ODBlZGRjYzFiOGNlY2I2YmE0YjhjNTY0ZmQ0NmYxZjE5ZWE0ZmFjZmU1ZmE3ZDNiMTBjNWY5NTJiNDQx; BA_HECTOR=840k800ga40ha185631g9prch0r; Hm_lpvt_de54c5cc453c7904719695d12c1a5daa=1620897830'}

# def getDate(HTMLCode):
#     datalist=[]
#
#     soup=BeautifulSoup(HTMLCode,'html.parser')
#     items=soup.find_all('div',class_='question-box que-select')
#     items1=soup.find_all('div', attrs={'class': 'question-box que-select last'})
#
#     for item in items:
#         data=[]
#         details = item.find('div', attrs={'class': 'questem-inner bdjson'})  # 题目
#         data.append(details)
#
#         answers = item.find_all('div', attrs={'class': 'queoptions-inner bdjson clearfix'})  # 四个选项
#         answer = str(answers)
#         data.append(answer)
#
#         jiexi=item.find('div',attrs={'class': 'view-analyse'})
#         link = jiexi.find('a').get('href')  # 解析页
#         link=('https:'+link)
#         data.append(link)
#         datalist.append(data)
#
#     for item in items1:
#         data1=[]
#         detail=item.find('div',attrs={'class':'questem-inner bdjson'})
#         data1.append(detail)
#         answers = item.find_all('div', attrs={'class': 'queoptions-inner bdjson clearfix'})  # 最后一个题目四个选项
#         data1.append(answers)
#         jiexi1 = item.find('div', attrs={'class': 'view-analyse'})
#         link = jiexi1.find('a').get('href')  # 解析页
#         link = ('https:' + link)
#
#         data1.append(link)
#         datalist.append(data1)
#     return datalist
#
#
# # def save_file(data):
# #     f = open("1.1 金属资源的开采及其污染治理.csv", mode='a', encoding='utf-8')
# #     for i in range(len(data)):
# #         for j in range(len(data[i])):
# #             data[i][j] = re.sub('<div class="questem-inner bdjson">|<div class="opt-item"><span class="prefix">|<span class="prefix">|<div class="opt-item">|<div class="queoptions-inner bdjson clearfix">','',str(data[i][j]))
# #             data[i][j] = re.sub('<p>|\[|<span>|</span>|</div>|<span class="ext_valign_sup">|</p>|<span class="ext_italic">|<span class="ext_valign_sub">|<em>|</em>|<span class="ext_bold">|', '', data[i][j]).strip()
# #             data[i][j] = (data[i][j].strip('[|]').strip())
# #
# #             f.write(data[i][j])
# #             print('保存成功')
# #             f.write(',')
# #         f.write('\n')
#

#
# def getHtml(urls):
#     req = requests.get(urls, headers=head)
#     req.encoding = 'utf-8'
#     html=req.text
#     soup = BeautifulSoup(html,'html.parser')
#
#     return html
#
#
# wangzhi='https://tiku.baidu.com/tikupc/chapterlist/1bfd700abb68a98271fefa04-23-jiaocai-11'
# reqhtml=getHtml(wangzhi)
#
# shuxue1=getDate(reqhtml)
# # save_file(shuxue1)



def saveSql(chaptername,bookname,timu,timuType,options,href,knowledge,chaptername2):  # 数学，章节，教材，题目，题目类型，选项，解析链接，考点
    db = pymysql.connect(host='139.224.41.157', user='root', passwd='1234', database='team01',port=3306)
    cursor = db.cursor()
    sql = "INSERT INTO shiti01(kemu_id,zhangjie_id,jiaocai_id,shiti_timu,shiti_type,shiti_option,shiti_daan_href,shiti_kaodian,createdate,remark) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
    try:
        cursor.execute(sql,(('数学',chaptername,bookname,timu,timuType,options,href,knowledge,time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()),chaptername2)))
        db.commit()
        print('导入数据库成功')
    except:
        print('发现错误')
        db.rollback()
    db.close()

wangzhi='https://tiku.baidu.com/tikupc/chapterlist/1bfd700abb68a98271fefa04-23-jiaocai-11'
req = requests.get(wangzhi, headers=head)
req.encoding = 'utf-8'
html = req.text
soup = BeautifulSoup(html, 'html.parser')
books = soup.find_all('ul',attrs={'class':'sc-subject clearfix'})[-1]
booknames = re.findall('<li.*?<a.*?>(.*?)</a>',str(books),re.S)
''' ***************************** 第一层获取书名、书的链接 **************************** '''
bookname = []    # 所有书名
for i in booknames:
    bookname.append(i.strip())
bookslinks = re.findall('<a href=(.*?)>',str(books),re.S)
bookslink = []   # 获得所有书本的链接
for href in bookslinks:
    href = 'https://tiku.baidu.com' + href.strip('"')
    bookslink.append(href)

for i in zip(bookslink,bookname):   # 进入第二层遍历
    print(i[1])
    ''' ***************************** 第二层获取章 **************************** '''
    reqNext = requests.get(i[0])
    reqNext.encoding = 'utf-8'
    htmlNext = reqNext.text
    soupNext = BeautifulSoup(htmlNext, 'html.parser')
    main = soupNext.find('div',attrs={'class':'list-right'})
    chapters = main.find_all('div',attrs={'class':'detail-chapter'})   # 获取章
    ''' ***************************** 第三层获取节 **************************** '''
    for chap in chapters:
        chaptername = chap.find('h3').text    #获得章名
        jielists = chap.find_all('div',attrs={'class':'detail-kpoint-1'})    # 获得节链接
        print(chaptername)
        for jie in jielists:
            jiename = jie.find('h4').text
            print(jiename)
            xiaojielists = jie.find_all('div',attrs={'class','detail-kpoint-2'})  # 获得小节链接
            ''' ***************************** 第四层获取单个小节 **************************** '''
            for xiaojie in xiaojielists:
                xiaojiename = xiaojie.find('h5').text  # 获得小节的名字
                xiaojielink = xiaojie.find('a')
                xiaojielink = 'https://tiku.baidu.com'+str(re.findall('href="(.*?)"',str(xiaojielink),re.S)).strip("[|]|'")  # 获取小节的链接
                countTi = xiaojie.find('span',attrs={'class':'count'}).text
                # print(countTi)
                print(xiaojielink)
                print(xiaojiename)
                pagesize = re.findall('-[0-9]-(.)-',xiaojielink)
                pageOne = int(countTi) // int(''.join(pagesize))   # 翻页
                pageremander = int(countTi) % int(''.join(pagesize))
                if pageremander == 0:
                    pageOne = pageOne - 1   # 若是整数要-1
                # print(pageOne)
                for num in range(pageOne):
                    xiaojielinkrange = re.sub('-[0-9]-5-', '-' + str(num * 5 + 1) + '-5-', xiaojielink)
                    print(xiaojielinkrange)
                    ''' ***************************** 第五层获取单个小节下的内容 **************************** '''
                    reqxiaojie = requests.get(xiaojielinkrange)
                    reqxiaojie.encoding = 'utf-8'
                    htmlxiaojie = reqxiaojie.text
                    soupxiaojie = BeautifulSoup(htmlxiaojie, 'html.parser')
                    Ticontent = soupxiaojie.find('div',attrs={'class':'que-stem'})
                    TiOne = Ticontent.find_all('div',attrs={'class':'question-box que-select'})
                    ''' ***************************** 第六层获取每个题的内容 **************************** '''
                    for Tione in TiOne:
                        ti_type = Tione.find('span',attrs={'class':'pieces'}).text.strip()
                        if (ti_type == '填空题') or (ti_type == '单选题'):
                            print(ti_type)
                            timu = Tione.find('div',attrs={'class':'questem-inner bdjson'}).text.strip()  # 题目
                            options = Tione.find('div',attrs={'class':'que-options'}).text.strip()  # 选项
                            answerlink = Tione.find('a',attrs={'class':'view-link'}).get('href')   # 解析
                            answerlink = 'https:' + answerlink
                            print(timu)
                            print(options)
                            print(answerlink)
                            if chaptername.split(' ')[0] =='第一章':
                                chaptername1 = 'ZJ001'
                            if chaptername.split(' ')[0] =='第二章':
                                chaptername1 = 'ZJ002'
                            if chaptername.split(' ')[0] =='第三章':
                                chaptername1 = 'ZJ003'
                            if chaptername.split(' ')[0] =='第四章':
                                chaptername1 = 'ZJ004'
                            if chaptername.split(' ')[0] =='第五章':
                                chaptername1 = 'ZJ005'
                            if chaptername.split(' ')[0] =='第六章':
                                chaptername1 = 'ZJ006'
                            if chaptername.split(' ')[0] =='第七章':
                                chaptername1 = 'ZJ007'
                            if chaptername.split(' ')[0] =='第八章':
                                chaptername1 = 'ZJ008'
                            if chaptername.split(' ')[0] =='第九章':
                                chaptername1 = 'ZJ009'
                            if chaptername.split(' ')[0] =='第十章':
                                chaptername1 = 'ZJ010'
                            if chaptername.split(' ')[0] =='第十一章':
                                chaptername1 = 'ZJ011'
                            if chaptername.split(' ')[0] =='第十二章':
                                chaptername1 = 'ZJ012'
                            if chaptername.split(' ')[0] =='第十三章':
                                chaptername1 = 'ZJ013'
                            if chaptername.split(' ')[0] =='第十四章':
                                chaptername1 = 'ZJ014'
                            if chaptername.split(' ')[0] =='第十五章':
                                chaptername1 = 'ZJ015'
                            else:
                                chaptername1 = 'ZJ016'
                            if i[1] == '必修1':
                                jiaocaiID = 'SX001'
                            if i[1] == '必修2':
                                jiaocaiID = 'SX002'
                            if i[1] == '必修3':
                                jiaocaiID = 'SX003'
                            if i[1] == '必修4':
                                jiaocaiID = 'SX004'
                            if i[1] == '必修5':
                                jiaocaiID = 'SX005'
                            if i[1] == '数学选修1-1':
                                jiaocaiID = 'SX006'
                            if i[1] == '数学选修1-2':
                                jiaocaiID = 'SX007'
                            if i[1] == '数学选修2-1':
                                jiaocaiID = 'SX008'
                            if i[1] == '数学选修2-2':
                                jiaocaiID = 'SX009'
                            if i[1] == '数学选修2-3':
                                jiaocaiID = 'SX010'
                            if i[1] == '数学选修4-1':
                                jiaocaiID = 'SX011'
                            if i[1] == '数学选修4-2':
                                jiaocaiID = 'SX012'
                            if i[1] == '数学选修4-4':
                                jiaocaiID = 'SX013'
                            if i[1] == '数学选修4-5':
                                jiaocaiID = 'SX014'
                            if i[1] == '数学选修4-7':
                                jiaocaiID = 'SX015'
                            saveSql(chaptername1, jiaocaiID, timu, ti_type, options, href, xiaojiename,chaptername.split(' ')[1])
                        # break  # 题目
                    # break   # 分页
                # break  # 小节  ———————————————1.1 集合的含义及表示
            # break  # 节  ————————————————1 集合
        # break  # 章 ————————————————第一章 集合与函数的概念
    # break  # 书  ——————————————必修1

