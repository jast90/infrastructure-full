// var api = require("../../../utils/api.js")
var api = require("../../../utils/mock.js")

Page({

  /**
   * 页面的初始数据
   */
  data: {
    categories: [],
    showAddModal: false,
    newCagoryName: "",
    newCagoryDesc: ""
  },

  /**
   * 显示添加类型Modal
   */
  showAddModal: function() {
    this.setData({
      showAddModal: true
    })
  },

  /**
   * 添加分类
   */
  categroyAdd: function(e) {
    api.categoryAdd({
      name: this.data.newCagoryName,
      desc: this.data.newCagoryDesc
    }, result => {
      if (result.resultCode == 0) {
        wx.showToast({
          title: '成功',
          icon: 'success',
          duration: 2000
        })
        this.onLoad()
        this.setData({
          newCagoryName: "",
          newCagoryDesc: ""
        });
      }
    });
  },

  /**
   * 更新名称
   */
  changeName: function(e) {
    var value = e.detail.value;
    this.setData({
      newCagoryName: value
    });
  },
  /**
   * 更新描述
   */
  changeDesc: function(e) {
    var value = e.detail.value;
    this.setData({
      newCagoryDesc: value
    });
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

    api.getCategoryList(data => this.setData({
      categories: data
    }))
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