import { useQuery } from "@tanstack/react-query";
import axios from "axios"

const API_URL = 'http://localhost:8080'
const fetchData = async() => {
    const response = axios.get(API_URL + '/fornecedor')
    return response;
}

export function useFornecedorData(){
    const query = useQuery({
        queryFn:fetchData,
        queryKey: ['fornecedor-data'],
        retry:2
    })
    return {
        ...query,
        data:query.data?.data
    }
}