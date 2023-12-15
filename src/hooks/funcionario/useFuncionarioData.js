import { useQuery } from "@tanstack/react-query";
import axios from "axios"

const API_URL = 'http://localhost:8080'
const fetchData = async() => {
    const response = axios.get(API_URL + '/funcionario')
    return response;
}

export function useFuncionarioData(){
    const query = useQuery({
        queryFn:fetchData,
        queryKey: ['funcionario-data'],
        retry:2
    })
    return {
        ...query,
        data:query.data?.data
    }
}