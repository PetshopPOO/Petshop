import { useEffect, useState } from "react";
import { Input } from "./Input";
import { Link, useNavigate } from "react-router-dom";
import { useServicoDataMutate } from "../../hooks/servico/useServicoDataMutate";

export function ServicoForm(){

    const [tipo,setTipo] = useState("");
    const [valor,setValor] = useState(0);

    const { mutate,isSuccess } = useServicoDataMutate();
    const navigate = useNavigate();

    const submit = () => {
        const servicoData = {
            tipo,
            valor
        }
        mutate(servicoData)
    }

    useEffect(() => {
        if(isSuccess){
            return navigate("/")
        }
        else{
            console.log("Erro ao preencher os campos!")
        }
    },[isSuccess])
    return(
        <>
            <Link to="/" className="btn btn-light">Voltar</Link>
            <h2>Adicionar novo Serviço</h2>
            <form action="">
                <Input label="Tipo" value={tipo} updateValue={setTipo}/>
                <Input label="Valor" value={valor} updateValue={setValor}/>
            </form>
            <Link onClick={submit} className="btn btn-success">Submit</Link>
        </>
    )
}