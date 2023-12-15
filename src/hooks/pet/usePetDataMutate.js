import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios from "axios"

const API_URL = 'http://localhost:8080'
const postData = async(data) => {
    const response = axios.post(API_URL + '/pet', data)
    return response;
}

export function usePetDataMutate(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn:postData,
        retry:2,
        onSuccess:() => {
            queryClient.invalidateQueries(['pet-data']);
        }
    })
    return mutate;
}