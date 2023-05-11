package com.example.kotlin.net;

import java.io.Serializable;

/**
 * 黄振伟
 * 2022/5/7
 * Describe ：
 */
public class GetResultBean implements Serializable {

    /**
     * token : eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMTAxMDUxOTc5MTIyNjAwMTEiLCJqdGkiOiI4NjMwNyJ9.lVs7upbtFJPIRZkfIgq8-0atl6ALyDV_UkSjf6fdjGM
     * user : {"userNo":"110105197912260011","businessNo":"34222419830726005X","name":"毛崟","organNo":"010000050000","organName":"公安部刑事侦查局","p1OrganNo":"010000050000","p1OrganName":"公安部刑事侦查局","p2OrganNo":"010000050000","p2OrganName":"公安部刑事侦查局","p3OrganNo":"010000050000","p3OrganName":"公安部刑事侦查局","systemAdmin":"0","policeNo":"000000","card":"110105197912260011","policeType":"01","telphone":"13552339646","phone":"13552339646","type":1,"zczlType":"3","clbdqpType":"1,2,3","roleId":"z238,z242","sex":null,"position":null,"groupId":null,"groupRoleId":null,"roleName":"1","roleDescribe":"4,7,8,9","isAdmin":1,"lev":0,"child":1,"photo":null}
     */

    private String token;
    private UserBean user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean implements Serializable {
        /**
         * userNo : 110105197912260011
         * businessNo : 34222419830726005X
         * name : 毛崟
         * organNo : 010000050000
         * organName : 公安部刑事侦查局
         * p1OrganNo : 010000050000
         * p1OrganName : 公安部刑事侦查局
         * p2OrganNo : 010000050000
         * p2OrganName : 公安部刑事侦查局
         * p3OrganNo : 010000050000
         * p3OrganName : 公安部刑事侦查局
         * systemAdmin : 0
         * policeNo : 000000
         * card : 110105197912260011
         * policeType : 01
         * telphone : 13552339646
         * phone : 13552339646
         * type : 1
         * zczlType : 3
         * clbdqpType : 1,2,3
         * roleId : z238,z242
         * sex : null
         * position : null
         * groupId : null
         * groupRoleId : null
         * roleName : 1
         * roleDescribe : 4,7,8,9
         * isAdmin : 1
         * lev : 0
         * child : 1
         * photo : null
         */

        private String userNo;
        private String businessNo;
        private String name;
        private String organNo;
        private String organName;
        private String p1OrganNo;
        private String p1OrganName;
        private String p2OrganNo;
        private String p2OrganName;
        private String p3OrganNo;
        private String p3OrganName;
        private String systemAdmin;
        private String policeNo;
        private String card;
        private String policeType;
        private String telphone;
        private String phone;
        private int type;
        private String zczlType;
        private String clbdqpType;
        private String roleId;
        private Object sex;
        private Object position;
        private Object groupId;
        private Object groupRoleId;
        private String roleName;
        private String roleDescribe;
        private int isAdmin;
        private int lev;
        private int child;
        private Object photo;

        public String getUserNo() {
            return userNo;
        }

        public void setUserNo(String userNo) {
            this.userNo = userNo;
        }

        public String getBusinessNo() {
            return businessNo;
        }

        public void setBusinessNo(String businessNo) {
            this.businessNo = businessNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrganNo() {
            return organNo;
        }

        public void setOrganNo(String organNo) {
            this.organNo = organNo;
        }

        public String getOrganName() {
            return organName;
        }

        public void setOrganName(String organName) {
            this.organName = organName;
        }

        public String getP1OrganNo() {
            return p1OrganNo;
        }

        public void setP1OrganNo(String p1OrganNo) {
            this.p1OrganNo = p1OrganNo;
        }

        public String getP1OrganName() {
            return p1OrganName;
        }

        public void setP1OrganName(String p1OrganName) {
            this.p1OrganName = p1OrganName;
        }

        public String getP2OrganNo() {
            return p2OrganNo;
        }

        public void setP2OrganNo(String p2OrganNo) {
            this.p2OrganNo = p2OrganNo;
        }

        public String getP2OrganName() {
            return p2OrganName;
        }

        public void setP2OrganName(String p2OrganName) {
            this.p2OrganName = p2OrganName;
        }

        public String getP3OrganNo() {
            return p3OrganNo;
        }

        public void setP3OrganNo(String p3OrganNo) {
            this.p3OrganNo = p3OrganNo;
        }

        public String getP3OrganName() {
            return p3OrganName;
        }

        public void setP3OrganName(String p3OrganName) {
            this.p3OrganName = p3OrganName;
        }

        public String getSystemAdmin() {
            return systemAdmin;
        }

        public void setSystemAdmin(String systemAdmin) {
            this.systemAdmin = systemAdmin;
        }

        public String getPoliceNo() {
            return policeNo;
        }

        public void setPoliceNo(String policeNo) {
            this.policeNo = policeNo;
        }

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public String getPoliceType() {
            return policeType;
        }

        public void setPoliceType(String policeType) {
            this.policeType = policeType;
        }

        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getZczlType() {
            return zczlType;
        }

        public void setZczlType(String zczlType) {
            this.zczlType = zczlType;
        }

        public String getClbdqpType() {
            return clbdqpType;
        }

        public void setClbdqpType(String clbdqpType) {
            this.clbdqpType = clbdqpType;
        }

        public String getRoleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public Object getSex() {
            return sex;
        }

        public void setSex(Object sex) {
            this.sex = sex;
        }

        public Object getPosition() {
            return position;
        }

        public void setPosition(Object position) {
            this.position = position;
        }

        public Object getGroupId() {
            return groupId;
        }

        public void setGroupId(Object groupId) {
            this.groupId = groupId;
        }

        public Object getGroupRoleId() {
            return groupRoleId;
        }

        public void setGroupRoleId(Object groupRoleId) {
            this.groupRoleId = groupRoleId;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleDescribe() {
            return roleDescribe;
        }

        public void setRoleDescribe(String roleDescribe) {
            this.roleDescribe = roleDescribe;
        }

        public int getIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(int isAdmin) {
            this.isAdmin = isAdmin;
        }

        public int getLev() {
            return lev;
        }

        public void setLev(int lev) {
            this.lev = lev;
        }

        public int getChild() {
            return child;
        }

        public void setChild(int child) {
            this.child = child;
        }

        public Object getPhoto() {
            return photo;
        }

        public void setPhoto(Object photo) {
            this.photo = photo;
        }
    }
}
