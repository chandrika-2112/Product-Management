import axios from 'axios'
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './View.css'

const ViewProduct = () => {

    const [product, setProduct] = useState([]);

    const navigate = useNavigate();
    
    useEffect(() => {
        axios.get("http://localhost:9000/allProducts").then((posRes) => {
            const {data} = posRes;
            setProduct(data);
        }, (errRes) => {
            console.log(errRes);
        })
    }, []);

    const edit_product = (pid) => {
        navigate(`/editProduct/${pid}`);
    }

    const delete_product = (pid) => {
        axios.delete(`http://localhost:9000/delete/${pid}`).then((posRes) => {
            console.log(posRes.data);
        }, (errRes) => {
            console.log(errRes);
        })
    }

    const home = () => {
        navigate("/");
    }

    return(
        <div className='container'>
            <h1> Product Details </h1>

            <table  >
                <thead>
                    <tr>
                        <th>pid</th>
                        <th>name</th>
                        <th>image</th>
                        <th>costPrice</th>
                        <th>quantity</th>
                        <th>origin</th>
                        <th>profit</th>
                        <th>sellPrice</th>
                        <th>gst</th>
                        <th>amount</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>

                <tbody>
                    {
                        product.map((item, index) => {
                            return(
                                <tr align="center" key={index}>
                                    <td>{item.pid}</td>
                                    <td>{item.name}</td>
                                    <td>
                                        <img src={item.image} alt="product image" width={50} height={50}></img>
                                    </td>
                                    <td>{item.costPrice}</td>
                                    <td>{item.quantity}</td>
                                    <td>{item.origin}</td>
                                    <td>{item.profit}</td>
                                    <td>{item.sellPrice}</td>
                                    <td>{item.gst}</td>
                                    <td>{item.amount}</td>
                                    <td>
                                        <i className='fa fa-edit'
                                           onClick={() => edit_product(item.pid)}></i>
                                    </td>
                                    <td>
                                        <i className='fa fa-trash'
                                           onClick={() => delete_product(item.pid)}></i>
                                    </td>
                                </tr>
                            );
                        })
                    }

                </tbody>
            </table>

            <button className="back" onClick={home} > Back To Home </button>

        </div>
    )

}

export default ViewProduct;