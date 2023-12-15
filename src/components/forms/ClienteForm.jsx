import { useEffect, useState } from "react";
import { Input } from "./Input";
import { useClienteDataMutate } from "../../hooks/cliente/useClienteDataMutate";
import { Link, useNavigate } from "react-router-dom";

export function ClienteForm(){

    const [cpf,setCpf] = useState("");
    const [nome,setNome] = useState("");
    const [telefones,setTelefones] = useState("");
    const [email,setEmail] = useState("");
    const [rua,setRua] = useState("");
    const [bairro,setBairro] = useState("");
    const [cidade,setCidade] = useState("");

    const { mutate,isSuccess } = useClienteDataMutate();
    const navigate = useNavigate();

    const submit = () => {
        const clienteData = {
            rua,
            bairro,
            cidade,
            cpf,
            nome,
            "telefones":[telefones],
            email
        }
        mutate(clienteData)
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
            <h2>Adicionar novo Cliente</h2>
            <form action="">
                <Input label="Cpf" value={cpf} updateValue={setCpf}/>
                <Input label="Nome" value={nome} updateValue={setNome}/>
                <Input label="Telefones" value={telefones} updateValue={setTelefones}/>
                <Input label="Email" value={email} updateValue={setEmail}/>
                <Input label="Rua" value={rua} updateValue={setRua}/>
                <Input label="Bairro" value={bairro} updateValue={setBairro}/>
                <Input label="Cidade" value={cidade} updateValue={setCidade}/>
            </form>
            <Link onClick={submit} className="btn btn-success">Submit</Link>
        </>
    )
}