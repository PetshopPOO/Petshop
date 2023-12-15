import { useEffect, useState } from "react";
import { Input } from "./Input";
import { Link, useNavigate } from "react-router-dom";
import { useFornecedorDataMutate } from "../../hooks/fornecedor/useFornecedorDataMutate";

export function FornecedorForm(){

    const [cnpj,setCnpj] = useState("");
    const [nome,setNome] = useState("");
    const [telefones,setTelefones] = useState("");
    const [rua,setRua] = useState("");
    const [bairro,setBairro] = useState("");
    const [cidade,setCidade] = useState("");

    const { mutate,isSuccess } = useFornecedorDataMutate();
    const navigate = useNavigate();

    const submit = () => {
        const fornecedorData = {
            rua,
            bairro,
            cidade,
            cnpj,
            nome,
            "telefones":[telefones]
        }
        mutate(fornecedorData)
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
            <h2>Adicionar novo Fornecedor</h2>
            <form action="">
                <Input label="Cnpj" value={cnpj} updateValue={setCnpj}/>
                <Input label="Nome" value={nome} updateValue={setNome}/>
                <Input label="Telefones" value={telefones} updateValue={setTelefones}/>
                <Input label="Rua" value={rua} updateValue={setRua}/>
                <Input label="Bairro" value={bairro} updateValue={setBairro}/>
                <Input label="Cidade" value={cidade} updateValue={setCidade}/>
            </form>
            <Link onClick={submit} className="btn btn-success">Submit</Link>
        </>
    )
}