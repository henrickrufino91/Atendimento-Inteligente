(function(){
 const fmt=n=>Number(n||0).toFixed(1).replace('.',',');
 async function atualizar(){
  try{
   const r=await fetch('/relatorios/api/tempo-real',{cache:'no-store'}).then(x=>{if(!x.ok)throw new Error();return x.json()});
   ['aguardando','chamadas','emAtendimento','finalizadasHoje','atendimentosAbertos'].forEach(k=>{const e=document.querySelector('[data-kpi="'+k+'"]');if(e)e.textContent=r[k]});
   document.querySelector('[data-kpi="esperaMediaMin"]').textContent=fmt(r.esperaMediaMin)+' min';
   document.querySelector('[data-kpi="slaRiscoHoje"]').textContent=fmt(r.slaRiscoHoje)+'%';
   document.getElementById('atualizadoEm').textContent=new Date(r.atualizadoEm).toLocaleTimeString('pt-BR');
   HospitalCharts.doughnut(document.getElementById('liveRisco'),r.riscos.map(x=>x.nivel),r.riscos.map(x=>x.quantidade));
   HospitalCharts.bars(document.getElementById('liveProfissionais'),r.profissionais.map(x=>x.profissional),r.profissionais.map(x=>x.atendimentos));
   const tb=document.querySelector('#liveTable tbody');tb.innerHTML=r.riscos.map(x=>`<tr><td>${x.nivel}</td><td>${x.quantidade}</td><td>${fmt(x.percentualDentroDoAlvo)}%</td></tr>`).join('');
  }catch(e){document.getElementById('statusLive').textContent='Falha ao atualizar';}
 }
 atualizar(); setInterval(atualizar,5000); window.addEventListener('resize',()=>setTimeout(atualizar,80));
})();
