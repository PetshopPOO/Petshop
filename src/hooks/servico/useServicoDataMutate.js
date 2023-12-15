import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios from "axios"

const API_URL = 'http://localhost:8080'
const postData = async(data) => {
    const response = axios.post(API_URL + '/servico/cadastraServico', data)
    return response;
}

export function useServicoDataMutate(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn:postData,
        retry:2,
        onSuccess:() => {
            queryClient.invalidateQueries(['servico-data']);
        }
    })
    return mutate;
}