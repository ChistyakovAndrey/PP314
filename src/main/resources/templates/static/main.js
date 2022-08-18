$(document).ready(function ($) {
    WIDTH = $(window).width();
    HEIGHT = $(window).height();

    $('.main-row').css("height", HEIGHT - $('.top_info_div').height() + "px");
    $('#add-new-user-btn').click(function () {
        $(this).css({"color": "#000", "background": "#fff", "border-color": "#D5D1D1"});
        $('#users-table-btn').css({"color": "#007bff", "background": "transparent", "border-color": "transparent"});
        $('.admin-page-content-wrapper').css("display", "none");
        $('.add-new-user-content-wrapper').css("display", "block");
    })
    $('#users-table-btn').click(function () {
        $(this).css({"color": "#000", "background": "#fff", "border-color": "#D5D1D1"});
        $('#add-new-user-btn').css({
            "color": "#007bff",
            "background": "transparent",
            "border-color": "transparent"
        });
        $('.admin-page-content-wrapper').css("display", "block");
        $('.add-new-user-content-wrapper').css("display", "none");
    })

    // let addForm = $('.new-user-form');
    // $(addForm).submit(function (){
    //     alert("form submitted");
    // });

    $('.add-user').click(function () {
        //$('.new-user-form').submit();
        let user = {
            'name': $('#new-name').val(),
            'surname': $('#new-surname').val(),
            'age': $('#new-age').val(),
            'email': $('#new-email').val(),
            'password': $('#new-pass').val(),
            'role': $('#new-roles').val()
        }
        alert(user);
        let myRequest = new Request('/api/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        });
        alert("add-user-2");
        fetch(myRequest)
            .then(response => {
                if (!response.ok)
                    alert(response.status);
                alert($('#new-pass').val());
                //throw new Error(`HTTP error! status: ${response.status}`);
                //return response.text();
            })
            .then(response => {
                let json = response.json();
                alert(json.email.toString());
            })
            .catch(error => console.log(error));
        //    const response = fetch('/api/users', {
        //             method: 'POST',
        //             headers: {
        //                 'Accept': 'application/json',
        //                 'Content-Type': 'application/json'
        //             },
        //             body: JSON.stringify({
        //                 param: 'значение'
        //             })
        //         });
        //         const content = response.json();
    })

});