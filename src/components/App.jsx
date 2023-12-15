import { Link } from 'react-router-dom'
import '../static/app.css'
import { useState } from 'react'

function App() {
  const [rota,setRota] = useState("/get");
  const handleRouteGet = () => {
    setRota("/get")
  }
  const handleRoutePost = () => {
    setRota("/post")
  }
  return (
    <>
      <div className='nav'>
        <h2>PetFeliz</h2>
        <img id='imagem' src="src/assets/pata.svg" width={20} height={20} alt="" />
      </div>
      <p>Opções</p>
      <button className='opcao' onClick={handleRoutePost}>Cadastrar</button>
      <button className='opcao' onClick={handleRouteGet}>Listar</button>
      <br />
      <h5>Entidades do Sistema</h5>
      <div className='container'>
        <div className="row">
          <div className="col">
            <Link to={rota + "/cliente"} className='btn btn-primary'>Cliente</Link>
          </div>
          <div className="col">
            <Link to={rota + "/funcionario"} className='btn btn-primary'>Funcionário</Link>
          </div>
        </div>       
        <div className="row">
            <div className="col">
              <Link to={rota + "/produto"} className='btn btn-primary'>Produto</Link>
            </div>
            <div className="col">
              <Link to={rota + "/servico"} className='btn btn-primary'>Serviço</Link>
            </div>
        </div>
        <div className='row'>
            <div className="col">
              <Link to={rota + "/pet"} className='btn btn-primary'>Pet</Link>
            </div>
            <div className="col">
              <Link to={rota + "/fornecedor"} className='btn btn-primary'>Fornecedor</Link>
            </div>
        </div>
        <div className='row'>
            <div className="col">
              <Link to={rota + "/servico"} className='btn btn-primary'>Serviço</Link>
            </div>
            <div className="col">
              <Link to={rota + "/venda"} className='btn btn-primary'>Item Venda</Link>
            </div>
        </div>
        <div className='row'>
            <div className="col">
              <Link to={rota + "/finalizaVenda"} className='btn btn-primary'>Finalizar Venda</Link>
            </div>
        </div>
      </div>
    </>
  )
}

export default App
