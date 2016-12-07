package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by lmw on 2016/12/6.
 */
public class ResponseSearch {

    /**
     * data : [{"tid":"1207576","fid":"2","groupname":"","author":"苏格兰少年","authorid":"1610994","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1610994&size=big","subject":"高Bigger挂画拯救你的家","dateline":"2016-09-19","lastpost":"2016-09-19","lastposter":"苏格兰少年","views":"100","replies":"0","fname":"北京装修论坛","fstatus":"1","attachments":["http://static-news.17house.com/bbs/forum/201609/19/135801yv87wmvgw7fwweji.png!w720","http://static-news.17house.com/bbs/forum/201609/19/135835m8jjzsxmsqmiid4m.jpg!w720","http://static-news.17house.com/bbs/forum/201609/19/135945hywpr9r1ftqyowh1.jpg!w720","http://static-news.17house.com/bbs/forum/201609/19/135946qkbabk2i8zjcpl3c.jpg!w720","http://static-news.17house.com/bbs/forum/201609/19/135836g6ta5d7r6w56u34n.jpg!w720"],"displayorder":"0","typeid":"0","digest":"0","zan":0,"attachment":"2","sharetimes":"0","message":"卢梭的作品《沉睡的吉卜赛人》挂在卧室里。<br ><br ><br ><br >米罗作品《月亮下的狗》。<br ><br ><br ><br >著名画家陈永锵的作品《三月木棉雄》挂在客厅里。<br ><br ><br ><br >大卫作品《巨人山》。<br ><br ><br ><br >    住着数百万的房子，买了最昂贵的家具，但你的品位最终很可能 ..."},{"tid":"1157551","fid":"4088","groupname":"","author":"向远我是scq","authorid":"1421059","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1421059&size=big","subject":"人生一世，活的就是一种精神 2zggtb4e","dateline":"2015-10-23","lastpost":"2015-10-23","lastposter":"向远我是scq","views":"25","replies":"0","fname":"【无锡装修论坛】","fstatus":"1","attachments":null,"displayorder":"0","typeid":"0","digest":"0","zan":0,"attachment":"0","sharetimes":"0","message":"人生的幸福美满其实就是一种感觉，一种心情。你是欢欣鼓舞、轻松快乐北京治疗牛皮癣那个医院好，还是孤独苦闷、疲劳不堪，主要有心态来支配。我们必须学会守住一颗平和宁静的心，做到内心平衡安宁，才能感受到生活 ..."},{"tid":"292870","fid":"3963","groupname":"","author":"丹麦福乐阁涂料","authorid":"824961","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=824961&size=big","subject":"丹麦Flugger福乐阁涂料\u2014\u2014100%丹麦纯进口，国内不做任何加工","dateline":"2012-10-03","lastpost":"2012-10-03","lastposter":"丹麦福乐阁涂料","views":"642","replies":"0","fname":"天津福乐阁涂料论坛","fstatus":"0","attachments":["http://static-news.17house.com/bbs/forum/201210/03/102626l5l3xxrr2z48f833.jpg!w720","http://static-news.17house.com/bbs/forum/201210/03/102630s4vd4zo3rdo3o3v0.jpg!w720","http://static-news.17house.com/bbs/forum/201210/03/1026333k36hlzddlk9h613.jpg!w720","http://static-news.17house.com/bbs/forum/201210/03/10263677gzz3g63321713s.jpg!w720","http://static-news.17house.com/bbs/forum/201210/03/102640rx3x8fvv1kotaf3x.jpg!w720","http://static-news.17house.com/bbs/forum/201210/03/102624c770vbhbzfuf0egv.jpg!w720"],"displayorder":"0","typeid":"0","digest":"0","zan":0,"attachment":"2","sharetimes":"0","message":null},{"tid":"14060","fid":"2","groupname":"","author":"docmas","authorid":"1421","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1421&size=big","subject":"【番外篇】司马儿和胡子GG近期的家具考察报告！","dateline":"2010-05-10","lastpost":"2010-06-03","lastposter":"docmas","views":"39991","replies":"39","fname":"北京装修论坛","fstatus":"1","attachments":["http://www.billiecountry.com/UploadFile/201003/d_201034104410_81026.jpg","http://changzhou.yuexing-home.com/UploadFile/file/a696e990-6ea3-4d06-89ae-4baec4499371.jpg","http://img07.taobaocdn.com/imgextra/i7/48377160/T2CYJbXktbXXXXXXXX_!!48377160.jpg","http://www3.tx8.cn/photo/mikehe0722/200932519141985.jpg","http://i00.c.aliimg.com/img/product/83/68/27/83682721.jpg"],"displayorder":"0","typeid":"28","digest":"1","zan":0,"attachment":"0","sharetimes":"0","message":"司马儿小盆友和胡子GG有段时间没出现鸟，给大家鞠躬致歉哇 不过相信大家可以想象得到，如此对装修乐在其中的两口子，不会两个周末加五一放假都不出门滴！行踪晚些再向大家汇报鸟，但是有些心得还是有点等不 ..."}]
     * currentPage : 1
     * totalCount : 4
     * error : 0
     * message : 成功
     */

    private int currentPage;
    private int totalCount;
    private String error;
    private String message;
    private List<DataBean> data;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * tid : 1207576
         * fid : 2
         * groupname :
         * author : 苏格兰少年
         * authorid : 1610994
         * avtUrl : http://bbs.17house.com/uc_server/avatar.php?uid=1610994&size=big
         * subject : 高Bigger挂画拯救你的家
         * dateline : 2016-09-19
         * lastpost : 2016-09-19
         * lastposter : 苏格兰少年
         * views : 100
         * replies : 0
         * fname : 北京装修论坛
         * fstatus : 1
         * attachments : ["http://static-news.17house.com/bbs/forum/201609/19/135801yv87wmvgw7fwweji.png!w720","http://static-news.17house.com/bbs/forum/201609/19/135835m8jjzsxmsqmiid4m.jpg!w720","http://static-news.17house.com/bbs/forum/201609/19/135945hywpr9r1ftqyowh1.jpg!w720","http://static-news.17house.com/bbs/forum/201609/19/135946qkbabk2i8zjcpl3c.jpg!w720","http://static-news.17house.com/bbs/forum/201609/19/135836g6ta5d7r6w56u34n.jpg!w720"]
         * displayorder : 0
         * typeid : 0
         * digest : 0
         * zan : 0
         * attachment : 2
         * sharetimes : 0
         * message : 卢梭的作品《沉睡的吉卜赛人》挂在卧室里。<br ><br ><br ><br >米罗作品《月亮下的狗》。<br ><br ><br ><br >著名画家陈永锵的作品《三月木棉雄》挂在客厅里。<br ><br ><br ><br >大卫作品《巨人山》。<br ><br ><br ><br >    住着数百万的房子，买了最昂贵的家具，但你的品位最终很可能 ...
         */

        private String tid;
        private String fid;
        private String groupname;
        private String author;
        private String authorid;
        private String avtUrl;
        private String subject;
        private String dateline;
        private String lastpost;
        private String lastposter;
        private String views;
        private String replies;
        private String fname;
        private String fstatus;
        private String displayorder;
        private String typeid;
        private String digest;
        private int zan;
        private String attachment;
        private String sharetimes;
        private String message;
        private List<String> attachments;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public String getGroupname() {
            return groupname;
        }

        public void setGroupname(String groupname) {
            this.groupname = groupname;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthorid() {
            return authorid;
        }

        public void setAuthorid(String authorid) {
            this.authorid = authorid;
        }

        public String getAvtUrl() {
            return avtUrl;
        }

        public void setAvtUrl(String avtUrl) {
            this.avtUrl = avtUrl;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getLastpost() {
            return lastpost;
        }

        public void setLastpost(String lastpost) {
            this.lastpost = lastpost;
        }

        public String getLastposter() {
            return lastposter;
        }

        public void setLastposter(String lastposter) {
            this.lastposter = lastposter;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getReplies() {
            return replies;
        }

        public void setReplies(String replies) {
            this.replies = replies;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getFstatus() {
            return fstatus;
        }

        public void setFstatus(String fstatus) {
            this.fstatus = fstatus;
        }

        public String getDisplayorder() {
            return displayorder;
        }

        public void setDisplayorder(String displayorder) {
            this.displayorder = displayorder;
        }

        public String getTypeid() {
            return typeid;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public String getAttachment() {
            return attachment;
        }

        public void setAttachment(String attachment) {
            this.attachment = attachment;
        }

        public String getSharetimes() {
            return sharetimes;
        }

        public void setSharetimes(String sharetimes) {
            this.sharetimes = sharetimes;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<String> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<String> attachments) {
            this.attachments = attachments;
        }
    }
}
