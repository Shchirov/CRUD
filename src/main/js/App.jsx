import React from "react";
import ReactDom from 'react-dom';
import {Row} from './Row.jsx';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {maxPos: 0, rows: [{id: null, text: null, changed: false, position: null}]};
        this.addRow = this.addRow.bind(this);
        this.save = this.save.bind(this);
        this.remove = this.remove.bind(this);
        this.textUpdate = this.textUpdate.bind(this);
        this.updateRows = this.updateRows.bind(this);
        this.updatePos = this.updatePos.bind(this);
        this.addedId = -1;
    }

    componentDidMount() {
        this.updateRows();
        console.log(this.state.rows)

    }

    updatePos(value) {
        if (value > this.state.maxPos)
            this.setState({maxPos: value});
    }

    updateRows() {
        let updatePos = this.updatePos;
        fetch('http://localhost:7070/message/', {
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            }
        })
            .then(res => res.json())
            .then(res => {
                this.setState({rows: res.map(x => ({id: x.id, text: x.text, changed: false, position:x.position}))});
                this.state.rows.map(function(o) { updatePos(o.position) });
                console.log(this.state.rows)
            });
    }

    remove(rowId) {
        this.setState({rows: this.state.rows.filter(item => (item.id !== rowId))});
    }

    addRow() {
        let newRow = this.state.rows;
        newRow.unshift({id: this.addedId, text: "", position: this.state.maxPos});
        this.setState({maxPos: this.state.maxPos + 1});
        this.setState({rows: newRow});
        this.addedId -= 1;
    }

    save() {
        let data = this.state
            .rows
            .filter(x => x.changed)
            .map(function (r) {
                return {id: r.id < 0 ? "null" : r.id, text: r.text, position: r.position};
            });
        console.log(data);
        fetch('http://localhost:7070/message/', {
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            method: 'POST'
        })
            .then(res => res.text())
            .then(res => {
                this.updateRows();
            });

    }

    textUpdate(id, text) {
        if (text === "") {
            this.remove(id);
        } else {
            let data = this.state
                .rows
                .map(function (r) {
                    if (r.id != id) {
                        return r;
                    } else {
                        return {id: r.id, text: text, changed: true,position: r.position};
                    }
                });
            this.setState({rows: data});
        }
    }

    render() {
        return (
            <div id="app">
                <div id="buttons">
                    <button id="add" onClick={this.addRow}>+</button>
                    <button id="save" onClick={this.save}>Сохранить</button>
                </div>
                <div id="rows">
                    {
                        this.state
                            .rows
                            .map((row, index) => (
                                console.log(this.state.rows),
                                    <Row id={row.id} text={row.text} remove={this.remove} key={row.id}
                                         textUpdate={this.textUpdate} changed={row.changed}/>
                            ))
                    }
                </div>
            </div>
        )
    }
}

ReactDom.render(<App/>, document.getElementById("react"));