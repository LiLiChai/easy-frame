/**
 * Created by Administrator on 2016/10/9.
 */
$(function(){
    $(".header_dh li").mousemove(function(){
        $("#mover").addClass("moak_he")
    });
    $(".header_dh").mouseout(function(){
        $("#mover").removeClass("moak_he")
    })
});

$(function(){
    $(".cnjaw li").mousemove(function(){
        $(this).addClass("neka").siblings().removeClass("neka");
        var id='#'+$(this).attr("_t_nav");
        $("#Dedicated").find(id).show().siblings(".cnakwe").hide();
    });
});

$(function(){
    $("#hcnas").click(function(){
        var kj=$("#hwcx_bac").css("display");
        if(kj=="none"){
            $("#hwcx_bac").fadeIn(300)
        }if(kj=="block"){
            $("#hwcx_bac").fadeOut(300)
        }
    })
});