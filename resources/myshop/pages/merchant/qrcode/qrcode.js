// pages/merchant/qrcode/qrcode.js
var uploadUrl = "http://www.baidu.com";
// var api = require("../../../utils/api.js")
var api = require("../../../utils/mock.js")

Page({

  /**
   * 页面的初始数据
   */
  data: {
    qrcode: ""
  },

  updateQRCode: function(e) {
    let that = this;
    wx.chooseImage({
      success: function(res) {
        var tempFilePaths = res.tempFilePaths;
        console.log(tempFilePaths);
        wx.uploadFile({
          url: uploadUrl,
          filePath: tempFilePaths[0],
          name: 'file',
          formData: {
            "id": 1
          },
          success: function(res) {
            var data = res.data;
            console.log(data)
            // 文件上传成功，更新用户收款码
            api.updateUserQRCode({
              "imgUrl":""
            },result=>{
              if(result.resultCode==0){
                that.onLoad();
              }
            })
          }
        })
      },
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    api.getUserQRCode({
      userId: 1
    }, data => {
      console.log(data);
      this.setData({
        qrcode: data
      });

    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})