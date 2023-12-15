import { useEffect, useState } from "react";
import { Input } from "./Input";
import { Link, useNavigate } from "react-router-dom";
import { useVendaTotalMutate } from "../../hooks/venda/useVendaTotalMutate";

export function VendaForm(){

    const [codigoVenda,setCodigoVenda] = useState(0);
    const [formaPagamento,setFormaPagamento] = useState("");
    const [cliente,setCliente] = useState("");
    const [funcionario,setFuncionario] = useState("");

    const { mutate,isSuccess } = useVendaTotalMutate();
    const navigate = useNavigate();

    const submit = () => {
        const vendaData = {
            codigoVenda,
            cliente,
            funcionario
        }
        mutate(vendaData)
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
            <h2>Adicionar nova Venda</h2>
            <form action="">
                <Input label="Código da Venda" value={codigoVenda} updateValue={setCodigoVenda}/>
                <Input label="Cliente" value={cliente} updateValue={setCliente}/>
                <Input label="Funcionário" value={funcionario} updateValue={setFuncionario}/>
                <Input label="Forma de Pagamento" value={formaPagamento} updateValue={setFormaPagamento}/>
            </form>
            <Link onClick={submit} className="btn btn-success">Submit</Link>
        </>
    )
}