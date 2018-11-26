//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    current: 'homepage',
    longitude: 0,
    latitude: 0
  },
  onShow: function() {
    wx.getLocation({
      type: 'wgs84',
      success: res => {
        console.log("location res" + res);
        const latitude1 = res.latitude
        const longitude1 = res.longitude
        this.setData({
          longitude: longitude1,
          latitude: latitude1
        })
      }
    })


  },
  handleChange({
    detail
  }) {
    this.setData({
      current: detail.key
    });
  },
  addAccountExpress: function(e) {
    if (e.detail.value.fromAddress.length == 0) {
      wx.showToast({
        title: '寄件地址不得为空!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function() {
        wx.hideToast()
      }, 2000)
    } else if (e.detail.value.toAddress.length == 0) {
      wx.showToast({
        title: '收件地址不得为空!',
        icon: 'loading',
        duration: 1500
      })
      setTimeout(function() {
        wx.hideToast()
      }, 2000)
    } else {
      wx.request({
        url: app.globalData.host + "/account/express",
        method: "POST",
        data: {
          toAddress: e.detail.value.toAddress,
          fromAddress: e.detail.value.fromAddress,
          longitude: e.detail.value.longitude,
          latitude: e.detail.value.latitude
        },
        success: function(res) {
          if (res.data.resultCode != 0) {
            wx.showToast({
              title: res.data.resultMsg,
              icon: 'loading',
              duration: 1500
            })
          } else {
            wx.showToast({
              title: res.data.resultMsg, //这里打印出登录成功
              icon: 'success',
              duration: 1000
            })
          }
        }
      })
    }
  }
})