/**
 * 发送POST请求
 */
function post(host,url, data, callback) {
    wx.request({
      url: host + url,
        data: JSON.stringify(data),
        method: "POST",
        success: function (res) {
            callback.success.call(res);
        },
        fail: function (res) {
            console.error("fail:" + res);
        },
        complete: function (res) {
            callback.complete.call(res);
        }
    });
}

/**
 * 发送get请求
 */
function get(host,url, callback) {
    wx.request({
      url: host + url,
        method: "GET",
        success: function (res) {
            callback.success.call(res);
        },
        fail: function (res) {
            console.error("fail:" + res);
        },
        complete: function (res) {
            callback.complete.call(res);
        }
    });
}

/**
 * http 请求工具
 * @type {{post: post, get: get}}
 */
module.exports = {
    get: get,
    post: post
}
