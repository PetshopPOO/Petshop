import { useEffect, useState } from "react";
import { Input } from "./Input";
import { Link, useNavigate } from "react-router-dom";
import { useFuncionarioDataMutate } from "../../hooks/funcionario/useFuncionarioDataMutate";

export function FuncionarioForm(){

    const [cpf,setCpf] = useState("");
    const [nome,setNome] = useState("");
    const [telefones,setTelefones] = useState("");
    const [matricula,setMatricula] = useState(0);
    const [rg,setRg] = useState("");
    const [salario,setSalario] = useState(0);
    const [rua,setRua] = useState("");
    const [bairro,setBairro] = useState("");
    const [cidade,setCidade] = useState("");

    const { mutate,isSuccess } = useFuncionarioDataMutate();
    const navigate = useNavigate();

    const submit = () => {
        const funcionarioData = {
            rua,
            bairro,
            cidade,
            cpf,
            nome,
            matricula,
            rg,
            salario,
            "telefones":[telefones]
        }
        mutate(funcionarioData)
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
            <h2>Adicionar novo Funcionário</h2>
            <form action="">
                <Input label="Cpf" value={cpf} updateValue={setCpf}/>
                <Input label="Nome" value={nome} updateValue={setNome}/>
                <Input label="Matrícula" value={matricula} updateValue={setMatricula}/>
                <Input label="Rg" value={rg} updateValue={setRg}/>
                <Input label="Salário" value={salario} updateValue={setSalario}/>
                <Input label="Telefones" value={telefones} updateValue={setTelefones}/>
                <Input label="Rua" value={rua} updateValue={setRua}/>
                <Input label="Bairro" value={bairro} updateValue={setBairro}/>
                <Input label="Cidade" value={cidade} updateValue={setCidade}/>
            </form>
            <Link onClick={submit} className="btn btn-success">Submit</Link>
        </>
    )
}