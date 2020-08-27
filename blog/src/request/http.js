import axios from 'axios';

// if(process.env.NODE_ENV=='dev'){
//     axios.defaults.baseURL='http://localhost:8080'
// }else if(process.env.NODE_ENV='pro'){
//     axios.defaults.baseURL='http://localhost:8080'
// }

//请求超时
axios.defaults.baseURL='/api'
axios.defaults.timeout=10000
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';

//请求拦截


//响应拦截
axios.interceptors.response.use(
    response=>{
        if (response.status ===200){
            return Promise.resolve(response);
        }else{
            return Promise.reject(response);
        }
    }
)

export function get(url,params) {
    return new Promise((resolve, reject) =>{
        axios.get(url, {
            params: params
        })
            .then(res => {
                resolve(res.data);
            })
            .catch(err => {
                reject(err.data)
            })
    });
}

export function post(url, params) {
    return new Promise((resolve, reject) => {
        axios.post(url, params)
            .then(res => {
                resolve(res.data);
            })
            .catch(err => {
                reject(err.data)
            })
    });
}


