package com.neishenmo.sochat.sochatandroid.view.message;


/**
 * @author Theaty
 * @desc 会员模型
 */
public class MemberModel{

    public int id;
    public String picture;//头像
    public String telephone;//手机号码
    public String name;//姓名
    public String sex;//性别
    public String helloedtelephone;
    public String age;    //年龄

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String birthday;
    public String stars;    //星座
    public String datevalue;    //几小时前
    public String distance;  //距离
    public String state;  //是否已注册资料
    public boolean isLike;
    public String token;//上传服务器所需token
    public String praise_count;//点赞数
    public String FROM_PHONE_NO;
    public String FROM_PICTURE;
    public String TO_PHONE_NO;
    public String TO_PICTURE;

    public String getFROM_PHONE_NO() {
        return FROM_PHONE_NO;
    }

    public void setFROM_PHONE_NO(String FROM_PHONE_NO) {
        this.FROM_PHONE_NO = FROM_PHONE_NO;
    }

    public String getFROM_PICTURE() {
        return FROM_PICTURE;
    }

    public void setFROM_PICTURE(String FROM_PICTURE) {
        this.FROM_PICTURE = FROM_PICTURE;
    }

    public String getTO_PHONE_NO() {
        return TO_PHONE_NO;
    }

    public void setTO_PHONE_NO(String TO_PHONE_NO) {
        this.TO_PHONE_NO = TO_PHONE_NO;
    }

    public String getTO_PICTURE() {
        return TO_PICTURE;
    }

    public void setTO_PICTURE(String TO_PICTURE) {
        this.TO_PICTURE = TO_PICTURE;
    }

    public String getCountRedpick() {
        return countRedpick;
    }

    public void setCountRedpick(String countRedpick) {
        this.countRedpick = countRedpick;
    }

    public String countRedpick;//红包数量
    public String blance;//钱包余额

    public String getBlance(){
        return blance;
    }
    public void setBlance(String blance){
        this.blance=blance;
    }

    public String getPraise_count(){
        return praise_count;
    }
    public void setPraise_count(String praise_count){
        this.praise_count=praise_count;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public MemberModel() {
    }

    public MemberModel(String picture, String name, String telephone) {
        this.picture = picture;
        this.name = name;
        this.telephone = telephone;
    }

    public MemberModel(String picture, String name, String age, String stars, String datevalue, String distance) {
        this.picture = picture;
        this.name = name;
        this.age = age;
        this.stars = stars;
        this.datevalue = datevalue;
        this.distance = distance;
    }

    public void setCurrentUserName(String name) {
        this.name = name;
    }

    public String getUserName() {
        if (name != null) {
            return telephone;
        }
        return name;
    }

//    /**
//     * 检验自身是否一个合法的类型
//     *
//     * @return
//     */
//    public String isLegal(String telephone) {
//
////		if (member_id <= 0) {
////			return " member_id非法";
////		}
//        LogUtils.e("手机号码"+telephone);
//        if (null==telephone||telephone.length() < 11) {
//            return " telephone非法";
//        }
////        if (TextUtils.isEmpty(name)) {
////            return " member_name非法";
////        }
//        return "access";
//    }
//
//    /**
//     * 根据用户手机号查询用户个人信息接口
//     *
//     * @param telephone 电话号码
//     * @param bib
//     */
//    public void getYanzhengma(String telephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", telephone));
//
//        HttpPostUtils.postSysHead("08");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                LogUtils.e(resultInfo.result);
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---");
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 根据用户手机号查询用户个人信息接口
//     *
//     * @param telephone 电话号码
//     * @param bib
//     */
//    public void getInfo(String telephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", telephone));
//        HttpPostUtils.postSysHead("16");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e(resultInfo.result);
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---");
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 获取他人页面详细信息
//     * @param telephone
//     * @param bib
//     */
//    public void getOtherUserInfo(String telephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", telephone));
//        HttpPostUtils.postSysHead("42");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e(resultInfo.result+"他人页面详情及行为列表");
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---");
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//    /**
//     * 注册第一步
//     * @param telephone
//     * @param Msg_code
//     * @param bib
//     */
//    public void firstRegister(String telephone, String Msg_code, final  BaseModelIB bib){
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", telephone));
//        map.add(new PostWordModel("msg_code", Msg_code));
//        HttpPostUtils.postSysHead("34");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                LogUtils.e(resultInfo.result+"注册成功返回信息");
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//
//                    }else {
//                        String error = jsonObject.getString("error");
//                        BIBFailed(bib, error+"..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                LogUtils.e("错误信息"+arg1+"----"+arg0.toString());
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//    /**
//     * 登录
//     * @param telephone
//     * @param Msg_code
//     * @param bib
//     */
//    public void loginIn(String telephone, String Msg_code, final  BaseModelIB bib){
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", telephone));
//        map.add(new PostWordModel("msg_code", Msg_code));
//        HttpPostUtils.postSysLoginHead("24");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                LogUtils.e(resultInfo.result+"登录返回信息");
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                    }else {
//                        String error = jsonObject.getString("error");
//                        BIBFailed(bib, error+"..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                LogUtils.e("错误信息"+arg1+"----"+arg0.toString());
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//    /**
//     * 注册接口
//     *
//     * @param telephone 电话号码
//     * @param bib
//     */
//    public void register(String telephone, String picture, String birthday, String sex, String name, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", telephone));
//        map.add(new PostWordModel("picture", picture));
//        map.add(new PostWordModel("birthday", birthday));
//        map.add(new PostWordModel("sex", sex));
//        map.add(new PostWordModel("name", name));
//       // map.add(new PostWordModel("circlePicture", circlePicture));
//
//        HttpPostUtils.postSysHead("35");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e(resultInfo.result+"---注册返回结果");
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 首页App发出搜索请求接口
//     *
//     * @param telephone 电话号码
//     * @param bib
//     */
//    public void indexSearch(String telephone, String x, String y, String simpleAddress, String detailAddress, int isok, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        Log.i("ssss", "indexSearch: "+url);
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", telephone));
//        map.add(new PostWordModel("ip", ""));//192.168.10.1
//        map.add(new PostWordModel("X", x));
//        map.add(new PostWordModel("Y", y));
//        map.add(new PostWordModel("simpleAddress", simpleAddress));
//        map.add(new PostWordModel("detailAddress", detailAddress));
//        map.add(new PostWordModel("isok", isok + ""));
//
//        HttpPostUtils.postSysHead("01");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e("首页数据"+resultInfo.result);
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//
//                List<MemberModel> memberModels = JSON.parseArray(resultInfo.result, MemberModel.class);
//                BIBSucessful(bib, memberModels);
//                /*try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//                    Object data = jsonObject.get("data");
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        BIBSucessful(bib, data);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//                    LogUtils.e(data.toString()+"---"+success);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }*/
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 点赞接口
//     *
//     * @param liketelephone：关注人手机号
//     * @param likedtelephone:被关注人手机号
//     * @param bib
//     */
//    public void follow(String liketelephone, String likedtelephone, String praiseCount , final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", liketelephone));
//        map.add(new PostWordModel("praisetelephone", likedtelephone));
//        map.add(new PostWordModel("praiseCount",praiseCount));
//
//        HttpPostUtils.postSysHead("25");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e("添加喜欢"+resultInfo.result);
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("msg");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---");
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 一个用户取消对另一个用户的关注接口
//     *
//     * @param caredtelephone:被关注人手机号
//     * @param caretelephone：关注人手机号
//     * @param bib
//     */
//    public void cancelfollow(String caredtelephone, String caretelephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("caredtelephone", caredtelephone));
//        map.add(new PostWordModel("caretelephone", caretelephone));
//
//        HttpPostUtils.postSysHead("09");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 获取一用户是否对另一用户关注接口
//     *
//     * @param caredtelephone:被关注人手机号
//     * @param caretelephone：关注人手机号
//     * @param bib
//     */
//    public void isfollow(String caredtelephone, String caretelephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("caredtelephone", caredtelephone));
//        map.add(new PostWordModel("caretelephone", caretelephone));
//
//        HttpPostUtils.postSysHead("07");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 一个用户修改另外一个用户备注接口
//     *
//     * @param caredtelephone:被关注人手机号
//     * @param caretelephone：关注人手机号
//     * @param bib
//     */
//    public void reviseNotes(String caredtelephone, String caretelephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("caredtelephone", caredtelephone));
//        map.add(new PostWordModel("caretelephone", caretelephone));
//
//        HttpPostUtils.postSysHead("10");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 一个用户查询自己关注的人信息（头像）接口
//     *
//     * @param caretelephone :关注的人手机号
//     * @param bib
//     */
//    public void queryFollow(String caretelephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("caretelephone", caretelephone));
//
//        HttpPostUtils.postSysHead("13");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 根据用户手机号查询用户个人信息接口
//     *
//     * @param telephone :用户手机号
//     * @param bib
//     */
//    public void getInfoWithPhone(String telephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", telephone));
//
//        HttpPostUtils.postSysHead("14");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 用户举报接口
//     *
//     * @param telephone    :举报人手机号
//     * @param suetelephone :被举报人手机号
//     * @param content      :举报内容
//     * @param bib
//     */
//    public void reportUser(String telephone, String suetelephone, String content, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", telephone));
//        map.add(new PostWordModel("suetelephone", suetelephone));
//        map.add(new PostWordModel("content", content));
//
//        HttpPostUtils.postSysHead("15");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 用户聊天记录保存接口
//     *
//     * @param telephonefrom :消息发送者手机号
//     * @param content       :用户聊天内容
//     * @param telephoneto   :消息接收者手机号
//     * @param bib
//     */
//    public void saveChatRecord(String telephonefrom, String content, String telephoneto, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephonefrom", telephonefrom));
//        map.add(new PostWordModel("content", content));
//        map.add(new PostWordModel("telephoneto", telephoneto));
//
//        HttpPostUtils.postSysHead("18");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 查询用户关注人数接口
//     *
//     * @param telephone :举报人手机号
//     * @param bib
//     */
//    public void getFollowNum(String telephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", telephone));
//
//        HttpPostUtils.postSysHead("18");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 添加查朋友圈的人信息数据接口（新增接口2018-01-09）【看过的人添加】
//     *
//     * @param visittelephone   :用户手机号
//     * @param visitedtelephone :查看朋友圈人的手机号
//     * @param bib
//     */
//    public void addSeeList(String visittelephone, String visitedtelephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("visittelephone", visittelephone));
//        map.add(new PostWordModel("visitedtelephone", visitedtelephone));
//
//        HttpPostUtils.postSysHead("30");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 查询查朋友圈的人信息数据接口（新增接口2018-01-09）【看过的人查询】
//     *
//     * @param hellotelephone :用户手机号
//     * @param bib
//     */
//    public void getSeeList(String hellotelephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("hellotelephone", hellotelephone));
//
//        HttpPostUtils.postSysHead("20");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 用户退出登录接口（新增接口2018-01-09）
//     *
//     * @param telephone :退出用户手机号
//     * @param bib
//     */
//    public void loginOut(String telephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "address_del 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", telephone));
//
//        HttpPostUtils.postSysHead("21");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e(resultInfo.result+"退出登录");
//                ResultsModel rm = ResultsModel.getInstanseFromStr(resultInfo.result);
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("msg");
//                        BIBSucessful(bib, data);
//
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 首页弹出消息框接口(2018-01-12 新增接口)
//     *
//     * @param type :活动类型
//     * @param bib
//     */
//    public void indexMessage(String type, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "appnsm 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("type", type));
//
//        HttpPostUtils.postSysHead("22");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//
//
//    /**
//     * 查询用户来访信息数据接口（新增接口2018-02-01）
//     *
//     * @param telephone :用户手机号
//     * @param bib
//     */
//    public void showSeeList(String telephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "appnsm 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", DatasStore.getPhonenumber()));
//
//        HttpPostUtils.postSysHead("32");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e(resultInfo.result+"关系页面来访人员列表");
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 查询用户喜欢信息数据接口（新增接口2018-02-01）
//     *
//     * @param telephone :用户手机号
//     * @param bib
//     */
//    public void showLikeList(String telephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "appnsm 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", DatasStore.getPhonenumber()));
//
//        HttpPostUtils.postSysHead("33");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e("关系页面用户喜欢数据"+resultInfo.result);
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//    /**
//     * 查询用户喜欢信息数据接口（新增接口2018-02-01）
//     *
//     * @param telephone :用户手机号
//     * @param bib
//     */
//    public void showFriendList(String telephone, final BaseModelIB bib) {
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "appnsm 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", DatasStore.getPhonenumber()));
//
//        HttpPostUtils.postSysHead("43");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e("关系页面好友列表数据"+resultInfo.result);
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 用户头像更换接口（App端上传用户需要更换的头像路径和用户手机号）。
//     * @param headerImage
//     * @param bib
//     */
//    public void changeUserHeaderImage(String headerImage, final BaseModelIB bib){
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "appnsm 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", DatasStore.getPhonenumber()));
//        map.add(new PostWordModel("picture", headerImage));
//
//        HttpPostUtils.postSysHead("14");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e(resultInfo.result+"修改用户头像返回结果");
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("msg");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     * 修改用户昵称
//     * @param userName
//     * @param bib
//     */
//    public void changeUserName(String userName, final BaseModelIB bib){
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "appnsm 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", DatasStore.getPhonenumber()));
//        map.add(new PostWordModel("nickname", userName));
//
//        HttpPostUtils.postSysHead("44");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e(resultInfo.result+"修改昵称返回结果");
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("msg");
//                        BIBSucessful(bib, data);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//    /**
//     * 获取点赞列表
//     * @param pageIndex
//     * @param bib
//     */
//    public void getPraiseList(String pageIndex, final BaseModelIB bib){
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "appnsm 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", DatasStore.getPhonenumber()));
//        map.add(new PostWordModel("pageIndex", pageIndex));
//
//        HttpPostUtils.postSysHead("47");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e(resultInfo.result+"获取点赞列表");
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                        LogUtils.e(data.toString()+"---"+success);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }
//
//    /**
//     *
//     * @param pageIndex
//     * @param bib
//     */
//    public void getRedPickList(String pageIndex, final BaseModelIB bib){
//        String url = buildGetUrl("nsm", "appnsm"); // 构建API地址
//        if (bib == null)
//            LogUtils.e("TTError", "appnsm 参数bib为null"); // 回调不能为空
//
//        BIBStart(bib); // 开始bib
//        RequestParams params = new RequestParams("UTF-8");
//        params.addHeader("token",DatasStore.getToken());
//        //传递参数
//        List<PostWordModel> map = new ArrayList<>();
//        map.add(new PostWordModel("telephone", DatasStore.getPhonenumber()));
//        map.add(new PostWordModel("pageIndex", pageIndex));
//        map.add(new PostWordModel("pageSize", "10"));
//
//        HttpPostUtils.postSysHead("48");
//        HttpPostUtils.postBody(map);
//        Gson gson = new Gson();
//        try {
//            String code = URLEncoder.encode(gson.toJson(HttpPostUtils.getPostData()), "utf-8");
//            params.setBodyEntity(new StringEntity(code, "UTF-8"));
//            params.setContentType("application/json");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        (genHttpUtils()).send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {// 开始请求
//            @Override
//            public void onSuccess(ResponseInfo<String> resultInfo) {
//                LogUtils.e(resultInfo.result+"获取红包列表");
//                try {
//                    JSONObject jsonObject = new JSONObject(resultInfo.result);
//
//                    boolean success = jsonObject.getBoolean("success");
//                    if(success){
//                        Object data = jsonObject.get("data");
//                        BIBSucessful(bib, data);
//                    }else {
//                        BIBFailed(bib, "网络状态不佳..."); // 失败标志位
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//            @Override
//            public void onFailure(HttpException arg0, String arg1) {
//                BIBFailed(bib, "网络超时..."); // 访问接口失败, 可能网络原因, 或者服务器宕机等造成
//            }
//        });
//    }

}