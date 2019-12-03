/**

 @Name：核心模块
 */

layui.define(['lmfEvent'], function (exports) {

    var lmfView = {},
        _parent = parent.window,
        $ = layui.jquery,
        lmfEvent = layui.lmfEvent;
    _parent.topPageBox = _parent.topPageBox || [];
    var view = {};

    var events = {
        topPageShow: function () {
            if (_parent.layui === layui) {
                return true;
            }
            if (!$(this).is('a')) {
                return true;
            }
            if (!$(this).attr('href')) {
                return true;
            }
            var title = $(this).data('title');
            var width = $(this).data('width');
            var height = $(this).data('height');
            var url = $(this).attr('href');

            return lmfView.topPageBox({
                title: title,
                width: width,
                height: height,
                url: url
            })
        },
        topPageClose: function () {

            if (_parent.layui === layui) {
                return true;
            }
            if (!$(this).is('a')) {
                return true;
            }
            if (!$(this).attr('href')) {
                return true;
            }
            lmfView.topPageClose();
            
            return false
        },
        topPageCloseAll: function () {

            if (_parent.layui === layui) {
                return true;
            }
            if (!$(this).is('a')) {
                return true;
            }
            if (!$(this).attr('href')) {
                return true;
            }
            lmfView.topPageCloseAll();
            
            return false
        }
    };
    var topPageBoxConfig = {
        title: '提示',
        width: '90%',
        height: '90%',
        maxmin: true,
        url: ''
    };
    
    lmfEvent.registerEvents(events);

    lmfView.topPageClose = function () {
        _parent.layui.layer.close(_parent.topPageBox[_parent.topPageBox.length - 1]);
    };
    lmfView.topPageCloseAll = function () {
        _parent.topPageBox.forEach(function (index) {
            _parent.layui.layer.close(index);
        });
        _parent.topPageBox = [];
    };
    lmfView.topPageBox = function (config) {
        var opts = $.extend(true, {}, topPageBoxConfig, config);
        if (opts.url == '') {
            lmfView.popup({
                content: '系统错误,请联系管理员'
            });
            return false
        }
        var _tbi = lmfView.popup({
            type: 2,
            maxmin: opts.maxmin,
            title: opts.title,
            shade: 0.2,
            area: [opts.width, opts.height],
            content: opts.url,
            end: function () {
                _parent.layui.event.call(lmfView, 'lmfView', 'topPageBox(end)', _parent);
                _parent.topPageBox.pop();
            },
            success: function () {
                _parent.layui.event.call(lmfView, 'lmfView', 'topPageBox(open)', _parent);
            },
            cancel: function () {
                _parent.layui.event.call(lmfView, 'lmfView', 'topPageBox(cancel)', _parent);
            }
        });
        _parent.topPageBox.push(_tbi);
        return false
    };
    //加载中
    lmfView.loading = function (elem) {
        _parent.layui.layer.load(2);
    };

    //移除加载
    lmfView.removeLoad = function () {
        _parent.layui.layer.closeAll('loading');
    };

    lmfView.redirect = function (url) {
        if (_parent.layui === layui) {
            location.href = url
        } else {
            _parent.layui.event.call(lmfView, 'lmfView', 'topPageBox(closeAll)', _parent);
            lmfView.topPageClose();
        }
    };
    lmfView.Notify = top.window.layui.layer.Notify;
    
    //弹窗
    lmfView.popup = function (options) {
        var success = options.success;
        var cancel = options.cancel;
        var end = options.end;

        delete options.success;
        delete options.cancel;
        delete options.end;
        return _parent.layui.layer.open($.extend({
            
            type: 1,
            title: '提示',
            shade: 0.2,
            area: ["80%", "80%"],
            success: function () {
                typeof success === 'function' && success.apply(this, arguments)
            },
            cancel: function () {
                typeof cancel === 'function' && cancel.apply(this, arguments)
            },
            end: function () {
                typeof end === 'function' && end.apply(this, arguments)
            }

        }, options));

    };

    //全局异常提示
    lmfView.error = function (content, options) {
        return view.popup($.extend({
            content: content
            , maxWidth: 300
            , offset: 't'
            , anim: 6
            , id: 'LAY_adminError'
        }, options))
    };


    lmfView.on = function (event, callback) {
        _parent.layui.event('lmfView', event, null, callback)
    };
    //对外接口
    exports('lmfView', lmfView);
});