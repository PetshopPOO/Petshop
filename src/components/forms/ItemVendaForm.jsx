import { useEffect, useState } from "react";
import { Input } from "./Input";
import { Link, useNavigate } from "react-router-dom";
import { useVendaDataMutate } from "../../hooks/venda/useVendaDataMutate";

export function ItemVendaForm(){

    const [codigo,setCodigo] = useState(0);
    const [preco,setPreco] = useState(0);
    const [quantidade,setQuantidade] = useState(0);
    const [codigoVenda,setCodigoVenda] = useState(0);

    const { mutate,isSuccess } = useVendaDataMutate();
    const navigate = useNavigate();

    const submit = () => {
        const itemVendaData = {
            codigo,
            preco,
            quantidade,
            codigoVenda
        }
        mutate(itemVendaData)
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
            <h2>Adicionar novo Item de Venda</h2>
            <form action="">
                <Input label="Produto" value={codigo} updateValue={setCodigo}/>
                <Input label="Preço" value={preco} updateValue={setPreco}/>
                <Input label="Quantidade" value={quantidade} updateValue={setQuantidade}/>
                <Input label="Código da Venda" value={codigoVenda} updateValue={setCodigoVenda}/>
            </form>
            <Link onClick={submit} className="btn btn-success">Submit</Link>
        </>
    )
}