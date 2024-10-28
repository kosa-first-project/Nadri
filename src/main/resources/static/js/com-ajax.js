const AJAX = {

    ajaxCall : function (method, url, data, callbackFunc) {
        const xhr = new XMLHttpRequest();

        if (method == 'GET') {
            xhr.open(method, url + data);
        } else {
            xhr.open(method, url);
        }
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.responseType = "json";
        xhr.send(JSON.stringify(data));

        xhr.onload = () => {
            if (xhr.status === 200) {
                callbackFunc(xhr.response);
            } else {
                alert(xhr.status, xhr.statusText);
            }
        }
    }
}