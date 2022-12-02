import axios from "axios";

const api = axios.create({
    baseURL: "http://locahost:1212"
});

const account = {
    login: async(login) => {
        const response = await api.post('account/login', login).catch((e) => console.log(e));
        return response;
    },
    register: async(register) => {
        var err = {}
        const response = await api.post('save', register)
        return response.data;
    },
    getAll: async() => {
        const response = await api.get('thread')
        return response.data;
    }
}

const agent = {
    account
}

export default agent;