import { useEffect, useState } from "react";
import { Input } from "./Input";
import { Link, useNavigate } from "react-router-dom";
import { useProdutoDataMutate } from "../../hooks/produto/useProdutoDataMutate";

export function ProdutoForm(){

    const [nome,setNome] = useState("");
    const [preco,setPreco] = useState(0);
    const [fornecedor,setFornecedor] = useState("");

    const { mutate,isSuccess } = useProdutoDataMutate();
    const navigate = useNavigate();

    const submit = () => {
        const produtoData = {
            nome,
            preco,
            fornecedor
        }
        mutate(produtoData)
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
            <h2>Adicionar novo Produto</h2>
            <form action="">
                <Input label="Nome" value={nome} updateValue={setNome}/>
                <Input label="Preço" value={preco} updateValue={setPreco}/>
                <Input label="Fornecedor" value={fornecedor} updateValue={setFornecedor}/>
            </form>
            <Link onClick={submit} className="btn btn-success">Submit</Link>
        </>
    )
}